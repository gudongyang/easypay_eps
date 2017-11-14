package com.gd.rpc.client;

import com.gd.rpc.ConsumerConfigure;
import com.gd.rpc.ProducerConfigure;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/5 上午11:33
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class RpcClientSendAndReceiveConf {
    final ConsumerConfigure consumerConfigure;
    final ProducerConfigure producerConfigure;


    //等待发送的消息；
    private int queueSize;


    public RpcClientSendAndReceiveConf(ProducerConfigure producerConfigure,
                                       ConsumerConfigure consumerConfigure,
                                       int size) {

        queueSize = size;
        this.consumerConfigure = consumerConfigure;
        this.producerConfigure = producerConfigure;
    }

    public int getQueueSize() {
        return queueSize;
    }
}


