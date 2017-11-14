package com.gd.rpc;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/6 下午3:39
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public interface RpcMsgGenerater {

    RpcMsg makeRpcMsg() throws InterruptedException;
}
