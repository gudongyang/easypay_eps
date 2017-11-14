package com.gd.rpc;

import com.gd.magic.ViewObject;
import com.gd.magic.util.JSONFormatter;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 上午9:13
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public class RpcMsg implements ViewObject{

    public String key;

    public String tag;

    public String body;

    public RpcMsg(String key, String tag, String body) {
        this.key = key;
        this.tag = tag;
        this.body = body;
    }

    public static final String SEPARATER = "=|=";

    public String strMsg() {
         return key + SEPARATER + tag + SEPARATER + body;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    static RpcMsg parseFromStr(String msg) {
        int pos = msg.indexOf(SEPARATER, 0);
        String key = msg.substring(0, pos);
        int pos2 = msg.indexOf(SEPARATER, pos + SEPARATER.length());
        String tag = msg.substring(pos + SEPARATER.length(), pos2);
        String body = msg.substring(pos2 + SEPARATER.length());
        return new RpcMsg(key, tag, body);
    }


    @Override
    public String toString() {
        return "RpcMsg{" +
                "key='" + key + '\'' +
                ", tag='" + tag + '\'' +
                ", body=" + body +
                '}';
    }
}
