package com.gd.rpc;

import java.util.Map;

public class ConsumerConfigure {
    private Map<String, String> c;
    private String[] cTopics;
    private String[] cTags;

    public ConsumerConfigure(Map<String, String> c,
                             String[] cTopics,
                             String[] cTags) {
        this.c = c;
        this.cTopics = cTopics;
        this.cTags = cTags;
    }

    public String[] getcTags() {
        return cTags;
    }

    public String[] getcTopics() {
        return cTopics;
    }

    public Map<String, String> getC() {
        return c;
    }
}