package com.gd.domain.mobile

import cn.test.Test
import com.gd.magic.anno.Service

import javax.net.ssl.SSLContext

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/10/15 下午1:03
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
class MobileService implements com.gd.magic.Service {

    static {
        //启动java1.7 de TLS1.2 默认1.0
        //jdk1.8 不用这样处理
        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
        ctx.init(null, null, null);
        SSLContext.setDefault(ctx);
    }
    @Service(dwr = true)
    def test() {
        Test.getFxQuote()
        Test.issueVAN()




    }

}
