package com.gd.domain.gw

import com.gd.magic.Service
import com.gd.si.mobile.Partner

/**
 * @author dy_gu king.gu@gmail.com   
 * @date 2017/10/23 下午2:39  
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved. 
 * @version V1.0
 */
class GatewayService implements Service {


    @com.gd.magic.anno.Service(dwr = true)
    def savePartner(Partner partner) {
        assert partner.name: "名称不能是空!"
        if (partner.signMethod == 1) {
            assert partner.signKey && partner.signKey.length() == 20: "签名秘钥格式错误"
        } else {
            assert partner.signKey: "请填入签名秘钥"
        }
        assert partner.encKey && partner.encKey.length() == 24: "加密秘钥格式错误"
        assert partner.partnerId && partner.partnerId.length() == 15:"接入结果号长度错误"
        partner.persistOrMerge()
    }


    @com.gd.magic.anno.Service(dwr = true)
    def removePartner(long id) {
        ejbService.removeById(Partner.class, id)
    }


    @com.gd.magic.anno.Service(dwr = true)
    def loadPartner(long id) {
        return ejbService.load(Partner.class, id)
    }


}
