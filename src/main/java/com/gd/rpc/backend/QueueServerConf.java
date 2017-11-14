package com.gd.rpc.backend;

import com.gd.rpc.ConsumerConfigure;
import com.gd.rpc.ProducerConfigure;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午10:15
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class QueueServerConf {

    ProducerConfigure producerConfigure;

    ConsumerConfigure consumerConfigure;


    /**
     * blockQueue 的容量
     */
    int capacity;

    /**
     * 消费线程个数
     */
    int workThreadNum;


    public QueueServerConf(ProducerConfigure producerConfigure,
                           ConsumerConfigure consumerConfigure,
                           int workThreadNum,
                           int capacity) {
        this.producerConfigure = producerConfigure;
        this.consumerConfigure = consumerConfigure;
        this.workThreadNum = workThreadNum;
        this.capacity = capacity;
    }
}
