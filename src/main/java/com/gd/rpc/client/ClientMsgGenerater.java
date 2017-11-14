package com.gd.rpc.client;

import com.gd.rpc.RpcMsg;
import com.gd.rpc.RpcMsgGenerater;

import java.util.concurrent.BlockingQueue;

public class ClientMsgGenerater implements RpcMsgGenerater {
    private final BlockingQueue<RpcMsg> queue;

    public ClientMsgGenerater(BlockingQueue<RpcMsg> queue) {
        this.queue = queue;
    }


    public RpcMsg makeRpcMsg() throws InterruptedException {
        return queue.take();
    }
}
