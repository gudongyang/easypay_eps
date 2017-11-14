package com.gd.rpc.backend;

import cn.test.kafka.KafkaUtil;
import com.gd.magic.util.JSONFormatter;
import com.gd.magic.util.JSONParser;
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
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午10:09
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */

/**
 * 处理消息并且返回
 */
public class MessageHandleServer {


    private Logger logger = LoggerFactory.getLogger(MessageHandleServer.class);
    private static MessageHandleServer instance;

    private QueueServerConf serverConf;


    private MessageHandleServer(QueueServerConf serverConf) {

        this.serverConf = serverConf;

    }


    private boolean isBootStrap = false;


    public synchronized void bootStrap() {

        if (!isBootStrap) {
            ConsumerConfigure consumerConfigure = serverConf.consumerConfigure;
            KafkaConsumer<String, String> consumer = KafkaUtil.getConsumer(consumerConfigure.getC());
            Set<String> tags = new HashSet<String>(consumerConfigure.getcTags().length);

            Collections.addAll(tags, consumerConfigure.getcTags());

            ProducerConfigure producerConfigure = serverConf.producerConfigure;

            KafkaProducer<String, String> producer = KafkaUtil.getProducer(producerConfigure.getP());

            final BlockingQueue<RpcMsg> blockingQueue = new ArrayBlockingQueue<RpcMsg>(serverConf.capacity);

            RpcMsgGeneraterAndHandle rpcMsgGeneraterAndHandle = new RpcMsgGeneraterAndHandle(blockingQueue);

            SendThread sendThread = new SendThread(producerConfigure.getpTopic(), producer, rpcMsgGeneraterAndHandle);


            ThreadPoolExecutor executor = RpcUtil.getThreadPool();

            executor.execute(new Thread(sendThread, "MessageHandleServer-sendThread"));


            Runnable runnable = new ReceiveThread(consumer,
                    consumerConfigure.getcTopics(),
                    tags,
                    rpcMsgGeneraterAndHandle);

            executor.execute(new Thread(runnable, "MessageHandleServer-ReceiveThread"));

            isBootStrap = true;
        } else {

            logger.debug("已经启动,不需要再次启动！");

        }


    }


    public synchronized static MessageHandleServer startServer(QueueServerConf serverConf) {
        if (instance == null) {
            instance = new MessageHandleServer(serverConf);
        }
        return instance;
    }


    static private class RpcMsgGeneraterAndHandle implements RpcMsgGenerater, RpcMsgHandle {

        private BlockingQueue<RpcMsg> queue;


        RpcMsgGeneraterAndHandle(BlockingQueue<RpcMsg> queue) {
            this.queue = queue;
        }

        public void handleMsg(RpcMsg rpcMsg) {


            //todo  业务代码

            //print out for test


            System.out.println(rpcMsg);


            Map  map = JSONParser.strToObject(rpcMsg.body, Map.class);


            map.put("b","hellWorld");


            rpcMsg.body= JSONFormatter.objectToStr(map);

            //返回原消息
            queue.offer(rpcMsg);


        }

        public RpcMsg makeRpcMsg() throws InterruptedException {
            return queue.take();
        }
    }

}
