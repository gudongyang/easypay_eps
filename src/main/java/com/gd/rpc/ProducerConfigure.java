package com.gd.rpc;

import java.util.Map;

public class ProducerConfigure {

    /**
     * 生产者配置
     */
    Map<String, String> p;

    /**
     * 生产者队列
     */
    String pTopic;

    public ProducerConfigure(Map<String, String> p, String pTopic) {
        this.p = p;
        this.pTopic = pTopic;
    }

    public String getpTopic() {
        return pTopic;
    }

    public Map<String, String> getP() {
        return p;
    }
}