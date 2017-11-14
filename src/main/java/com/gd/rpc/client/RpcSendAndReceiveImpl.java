package com.gd.rpc.client;

import cn.test.kafka.KafkaUtil;
import com.gd.rpc.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午9:15
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class RpcSendAndReceiveImpl implements RpcSendAndReceive {

    private static Logger logger = LoggerFactory.getLogger(RpcSendAndReceiveImpl.class);


    private RpcClientSendAndReceiveConf conf;
    private BlockingQueue<RpcMsg> queue;
    private Map<String, Object> locks = new ConcurrentHashMap<String, Object>();
    private Map<String, RpcMsg> values = new ConcurrentHashMap<String, RpcMsg>();
    private SendThread sendThread;
    private ReceiveThread receiveThread;


    public RpcSendAndReceiveImpl(RpcClientSendAndReceiveConf conf) {
        this.conf = conf;
        init();
    }


    public RpcMsg sendAndRecv(String uniqueId, String tag, String request) {

        Object lock = new Object();
        locks.put(uniqueId, lock);

        try {
            queue.put(new RpcMsg(uniqueId, tag, request));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            try {
                lock.wait(6 * 10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return values.remove(uniqueId);
    }


    public synchronized void init() {

        logger.debug("begin init.");

        logger.debug("queueSize:" + conf.getQueueSize());
        //吞吐量大小
        queue = new ArrayBlockingQueue<RpcMsg>(conf.getQueueSize());

        ConsumerConfigure consumerConfigure = conf.consumerConfigure;
        KafkaConsumer<String, String> consumer = KafkaUtil.getConsumer(consumerConfigure.getC());
        ProducerConfigure producerConfigure = conf.producerConfigure;
        KafkaProducer<String, String> producer = KafkaUtil.getProducer(producerConfigure.getP());

        Set<String> tags = new HashSet<String>(consumerConfigure.getcTags().length);

        Collections.addAll(tags, consumerConfigure.getcTags());

        receiveThread = new ReceiveThread(consumer,
                consumerConfigure.getcTopics(),
                tags,
                new ClientRecvMsgHandle(locks, values));

        //接收发送各一个线程
        sendThread = new SendThread(producerConfigure.getpTopic(), producer, new ClientMsgGenerater(queue));


        logger.debug("start  sendThread and receiveThread.");
        RpcUtil.getThreadPool().execute(new Thread(sendThread, "ClientSendThread"));
        RpcUtil.getThreadPool().execute(new Thread(receiveThread, "ClientReceiveThread"));
        logger.debug("begin init end.");


    }


    public synchronized void shutdown() {
        receiveThread.shutdown();
        sendThread.shutDown();
    }

}
