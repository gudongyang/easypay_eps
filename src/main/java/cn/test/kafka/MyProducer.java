package cn.test.kafka;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.HashMap;

public class MyProducer {

    public static void main(String[] s) {

        try {

            Producer<String, String> producer = KafkaUtil.getProducer(new HashMap<String,String>());
            int i = 0;
            while (true) {

                String key = String.valueOf(System.currentTimeMillis());

                System.out.println("key:" + key);

                ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", key, "this is message " + i);

                final int n = i;
                producer.send(record, new Callback() {
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if (e != null) {
                            e.printStackTrace();
                        } else {
                            System.out.println("message send to partition " + metadata.partition() + ", offset: " + metadata.toString());
                        }
                    }
                });
                i++;
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
