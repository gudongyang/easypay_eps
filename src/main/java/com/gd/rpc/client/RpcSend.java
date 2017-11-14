package com.gd.rpc.client;

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/11/5 上午11:31
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
public interface RpcSend {

    void send(String uniqueId, String tag, Object request);

    void shutdown();

}
