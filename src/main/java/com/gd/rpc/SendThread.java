package com.gd.rpc;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午9:14
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class SendThread implements Runnable {

    private KafkaProducer<String, String> producer;
    private RpcMsgGenerater rpcMsgGenerater;
    private String topic;
    private final AtomicBoolean closed = new AtomicBoolean(false);


    static Logger logger = LoggerFactory.getLogger(SendThread.class);

    public SendThread(String topic,
                      KafkaProducer<String, String> producer,
                      RpcMsgGenerater rpcMsgGenerater) {
        this.producer = producer;
        this.rpcMsgGenerater = rpcMsgGenerater;

        this.topic = topic;
    }

    public void run() {

        while (!closed.get()) {
            RpcMsg msg;

            try {
                msg = rpcMsgGenerater.makeRpcMsg();
            } catch (InterruptedException e) {
                //todo
                e.printStackTrace();
                continue;
            }


            logger.debug("begin send msg :" + msg.key);

            final ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg.key, msg.strMsg());

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {

                        logger.debug("send error,key:" + record.key() + ",value:" + record.value());

                        logger.error(record.key() + ",error msg", e);

                    } else {
                        logger.info(record.key() + ",send success");
                    }
                }
            });
        }

        logger.info("exit thread ,"+Thread.currentThread().getName());

    }

    public void shutDown() {
        closed.set(true);
    }
}
