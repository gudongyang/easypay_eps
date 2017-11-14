package com.gd.rpc;

import com.gd.rpc.backend.QueueServerConf;
import com.gd.rpc.client.RpcClientSendAndReceiveConf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 下午10:53
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class TestServerMain {


    public static void main(String[] args) {

        Map<String, String> consumeProp = new HashMap<String, String>();


        consumeProp.put("group.id", "13");

        consumeProp.put("max.poll.records", "10");//每次最多取10条记录
        String[] consumeTopics = new String[]{"ChannelAppServer"};
        String[] consumeTags = new String[]{"default"};

        ConsumerConfigure consumerConfigure = new ConsumerConfigure(
                consumeProp,
                consumeTopics,
                consumeTags
        );


        Map<String, String> producerProp = new HashMap<String, String>();

        String producerTopic = "CoreAppServer";

        ProducerConfigure producerConfigure = new ProducerConfigure(producerProp, producerTopic);

//        RpcClientSendAndReceiveConf conf = new RpcClientSendAndReceiveConf(producerConfigure,
//                consumerConfigure,
//                50);

        QueueServerConf serverConf = new QueueServerConf(producerConfigure, consumerConfigure, 1, 50);

        RpcUtil.startQueueServer(serverConf);


    }
}
