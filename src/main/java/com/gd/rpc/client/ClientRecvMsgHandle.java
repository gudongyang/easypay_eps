package com.gd.rpc.client;

import com.gd.rpc.RpcMsg;
import com.gd.rpc.RpcMsgHandle;

import java.util.Map;

public class ClientRecvMsgHandle implements RpcMsgHandle {
    private final Map<String, Object> locks;
    private final Map<String, RpcMsg> values;

    public ClientRecvMsgHandle(Map<String, Object> locks,
                               Map<String, RpcMsg> values) {
        this.locks = locks;
        this.values = values;
    }


    public Map<String, RpcMsg> getValues() {
        return values;
    }


    public void handleMsg(RpcMsg rpcMsg) {

        values.put(rpcMsg.key, rpcMsg);
        Object obj = locks.remove(rpcMsg.key);

        if (obj == null) {
            System.out.println("找到不到原交易请求超时或者丢失。 丢弃消息:" + rpcMsg.toString());
            return;
        }
        synchronized (obj) {
            obj.notify();
        }
    }
}
