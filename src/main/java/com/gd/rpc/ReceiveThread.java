package com.gd.rpc;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午9:14
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class ReceiveThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ReceiveThread.class);

    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final KafkaConsumer<String, String> consumer;


    private String[] topics;
    private Set tags; //自定义用来过滤消息
    private RpcMsgHandle clientRpcMsgHandle;

    public ReceiveThread(KafkaConsumer<String, String> consumer,
                         String[] topics,
                         Set tags,
                         RpcMsgHandle clientRpcMsgHandle) {
        this.consumer = consumer;
        this.topics = topics;
        this.tags = tags;
        this.clientRpcMsgHandle = clientRpcMsgHandle;
    }

    public void run() {
        try {
            consumer.subscribe(Arrays.asList(topics));
            consumer.seekToBeginning(new ArrayList<TopicPartition>());

            while (!closed.get()) {
                ConsumerRecords<String, String> records = consumer.poll(1000);

                for (ConsumerRecord<String, String> record : records) {
                    String key = record.key();
                    String msg = record.value();
                    RpcMsg rpcMsg = RpcMsg.parseFromStr(msg);

                    if (!tags.contains(rpcMsg.tag)) {
                        //todo check

                        System.err.println("tag error ignore msg! \n+" + rpcMsg.tag);
                        continue;
                    }

                    if (!key.equals(rpcMsg.key)) {
                        //todo
                        System.err.println("key error ignore msg! \n+" + rpcMsg.key);
                        continue;
                    }

                    clientRpcMsgHandle.handleMsg(rpcMsg);
                }
            }

            logger.info("exit thread ," + Thread.currentThread().getName());

        } catch (WakeupException e) {
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    // Shutdown hook which can be called from a separate thread
    public void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }
}
