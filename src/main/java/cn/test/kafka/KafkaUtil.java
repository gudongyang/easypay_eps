package cn.test.kafka;


import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KafkaUtil {
    private static KafkaProducer<String, String> kp;
    private static KafkaConsumer<String, String> kc;


    private static Lock cLock = new ReentrantLock();
    private static Lock pLock = new ReentrantLock();


    private static Logger logger = LoggerFactory.getLogger(KafkaUtil.class);


    public static KafkaProducer<String, String> getProducer(Map<String, String> prop) {
        if (kp == null) {
            cLock.lock();
            if (kp == null) {
                try {
                    Properties props = new Properties();
                    props.put("bootstrap.servers", "180.153.104.86:9092");
                    props.put("acks", "1"); //acks是判断消息是否成功发送的条件，将acks指定为"all"将会阻塞消息，当所有的副本都返回后才表明该消息发送成功，这种设置性能最低，但是是最可靠的。
                    props.put("retries", 1);//重试次数  大于1  有可能消息重复

                    for (Map.Entry<String, String> entry : prop.entrySet()) {
                        props.put(entry.getKey(), entry.getValue());
                    }
//          props.put("batch.size", 16384);
                    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                    kp = new KafkaProducer<String, String>(props);
                } finally {
                    cLock.unlock();
                }
            }
        }
        return kp;
    }


    public static KafkaConsumer<String, String> getConsumer(Map<String, String> prop) {
        if (kc == null) {
            pLock.lock();
            if (kc == null) {
                try {
                    Properties props = new Properties();
                    props.put("bootstrap.servers", "180.153.104.86:9092");

                    if (prop.get("group.id") == null) {
                        logger.warn("group.id not set  user default as  groupd.id");
                    } else {
                        logger.info("group.id:" + prop.get("group.id"));
                    }

                    props.put("group.id", "default");

                    props.put("enable.auto.commit", "false");   //是否自动提交
//                    props.put("auto.commit.interval.ms", "1000"); //自动提交间隔


                    props.put("session.timeout.ms", "30000");

                    for (Map.Entry<String, String> entry : prop.entrySet()) {
                        props.put(entry.getKey(), entry.getValue());
                    }
                    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
                    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
                    kc = new KafkaConsumer<String, String>(props);
                } finally {
                    pLock.unlock();
                }
            }
        }

        return kc;
    }
}