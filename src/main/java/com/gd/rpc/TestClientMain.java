package com.gd.rpc;

import com.gd.magic.util.JSONFormatter;
import com.gd.magic.util.JSONParser;
import com.gd.rpc.client.RpcClientSendAndReceiveConf;
import com.gd.rpc.client.RpcSendAndReceive;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 下午5:35
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class TestClientMain {


    public static void main(String[] args) throws InterruptedException {


        Map<String, String> consumeProp = new HashMap<String, String>();
        consumeProp.put("max.poll.records", "10");//每次最多取10条记录
        String[] topics = new String[]{"CoreAppServer"};
        String[] tags = new String[]{"default"};
        ConsumerConfigure consumerConfigure = new ConsumerConfigure(consumeProp,
                topics,
                tags
        );

        Map<String, String> producerProp = new HashMap<String, String>();

        String producerTopic = "ChannelAppServer";
        ProducerConfigure producerConfigure = new ProducerConfigure(producerProp, producerTopic);

        RpcClientSendAndReceiveConf conf = new RpcClientSendAndReceiveConf(producerConfigure,
                consumerConfigure,
                50);

        RpcSendAndReceive client = RpcUtil.getSendAndRecv(conf);


        for (int i = 0; i < 100; i++) {


            Map<String, Object> requestBody = new HashMap<String, Object>();

            requestBody.put("key" + i, i);
            String body = JSONFormatter.objectToStr(requestBody);


            RpcMsg msg = client.sendAndRecv(System.currentTimeMillis() + "-" + i,
                    "default", body
            );


            System.out.println(msg.body);
            System.out.println(JSONParser.strToObject(msg.body, null).getClass());

//            System.out.println("result------>" + JSONParser.strToObject(msg.getBody(), null)
//            );

            Thread.sleep(1000);


        }

//        client.shutdown();

    }
}
