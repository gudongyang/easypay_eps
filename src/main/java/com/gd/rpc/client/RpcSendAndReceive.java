package com.gd.rpc.client;

import com.gd.rpc.RpcMsg;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/5 上午11:30
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public interface RpcSendAndReceive {

    RpcMsg sendAndRecv(String uniqueId, String tag, String request);

    void shutdown();
}
