package com.gd.domain.party

import com.gd.magic.anno.Service
import com.gd.magic.util.StringUtil

/**
 * 操作员登录Service
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @author wangyuguo
 * @since 0.2
 */
class LoginService implements com.gd.magic.Service {
    public static final String PASSWORD_KEY = "PASSWORD"

    @Service(dwr = true)
    def getCurrentLogin() {
        return magicHelper.userId
    }

    @Service(dwr = true)
    void login(String clearText) {
        logger.debug("hello")
//        assert clearText: "密码校验失败"
        def password = "123456"
		assert password == (clearText): "密码校验失败"

        def session = magicHelper.getSession()
        if (session != null) {
            sessionService.removeSession(session.id)
        }
        session = sessionService.createSession(new Date().getTime())
        magicHelper.setSession(session)
    }

    String encrypt(String original) {
        if (!original) return
        byte[] encoded = softKeyService.desEncrypt(PASSWORD_KEY, original.trim().getBytes())
        return StringUtil.bytesToHexStr(encoded)
    }
    /**
     * 注销当前Session
     */
    public void logout() {
        def session = magicHelper.getSession()
        if (session) {
            sessionService.removeSession(session.id)
            magicHelper.setSession(null)
        }
    }


    @Service(dwr = true)
    def findModules(Long parentId) {
        if (parentId) {
            return ejbService.find("from Module as o where o.parent.id =? order by moduleIndex", parentId)
        } else {
//            return ejbService.find("from Module as o where o.parent.id =? order by moduleIndex", 100000L)

            return ejbService.find("from Module as o where o.parent is null order by moduleIndex")
        }
    }

    public def getDictItems(String dict) {
        def result = []
        dictService.getItems(dict).each {
            result.add([code: it.id, text: it.text])
        }
        return result
    }

    @Service(dwr = true)
    def findSystemState() {
        def deploy = magicHelper.getCurrentDeploy()
        def epsOrg = propertyService.getSystemPropertyValue("epsOrgName");
        def epsUnqueId = propertyService.getSystemPropertyValue("epsOrgNo");
        return [application: deploy.application, version: deploy.version, epsOrgName: epsOrg, epsOrgNo: epsUnqueId]
    }

    /**
     * 设置系统属性
     * @param propertyName
     * @param propertyValue
     * @return
     */
    void setSystemProperty(String name, String value) {
        propertyService.setSystemProperty(name, value)
    }

    /**
     * 查看系统属性
     * @return
     */
    def findSysProperties() {
        return propertyService.getSystemProperties()
    }

    /**
     * 修改EPS密码
     *
     */
    void saveEpsPassword(String oldPswd, String newPswd) {
        def password = propertyService.getSystemPropertyValue(EpsProperty.EPS_PASSWORD)
        assert password == encrypt(oldPswd): "密码校验失败"
        setEpsPassword(newPswd);
    }

    /**
     * 修改EPS密码
     *
     */
    void setEpsPassword(String newPswd) {
        setSystemProperty(EpsProperty.EPS_PASSWORD, encrypt(newPswd));
    }
}