package com.gd.rpc;

import com.gd.rpc.backend.MessageHandleServer;
import com.gd.rpc.backend.QueueServerConf;
import com.gd.rpc.client.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/2 下午1:46
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public abstract class RpcUtil {


    public static RpcSend getSend(RpcSendFactory factory) {
//        return factory.getInstance();
        return null;
    }


    public static RpcSendAndReceive getSendAndRecv(RpcClientSendAndReceiveConf conf) {

        return new RpcSendAndReceiveImpl(conf);
    }


    public static ThreadPoolExecutor getThreadPool() {

        ThreadPoolExecutor globalThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        globalThreadPool.setCorePoolSize(5);
        globalThreadPool.setMaximumPoolSize(100);
        return globalThreadPool;

    }


    public static void startQueueServer(QueueServerConf serverConf) {

        MessageHandleServer.startServer(serverConf).bootStrap();
    }

}
