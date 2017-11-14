package cn.test.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MyConsumer {


    public static void main(String[] s) {

        KafkaConsumer<String, String> consumer = KafkaUtil.getConsumer(new HashMap<String, String>());
        consumer.subscribe(Arrays.asList("test"));
        consumer.seekToBeginning(new ArrayList<TopicPartition>());

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(30000);


            int size = 0;
            for (ConsumerRecord<String, String> record : records) {
                size++;
                System.out.println("fetched from partition " + record.partition() + ", offset: " + record.offset() + ", message: " + record.value()+" ,key: "+record.key());
            }

//            System.err.print("get " + size + ">>>>>>>>>>>>>>>>>.");
            //按分区读取数据
//              for (TopicPartition partition : records.partitions()) {
//                  List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
//                  for (ConsumerRecord<String, String> record : partitionRecords) {
//                      System.out.println(record.offset() + ": " + record.value());
//                  }
//              }

        }

    }

}
