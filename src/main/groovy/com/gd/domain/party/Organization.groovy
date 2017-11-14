package com.gd.domain.party


import com.gd.magic.RootEntity
import com.gd.magic.anno.Column
import com.gd.magic.anno.Entity

@Entity(cacheUsage = "nonstrict-read-write")
class Organization extends RootEntity implements Cloneable {
    public static final int ENABLED = 1            //有效
    public static final int DISABLED = 2        //无效
    public static final int DELETED = 99        //无效


    @Column(size = 40)
    String logoUrl                                            //机构logo

//    @Column(dict = "org_level")
    int orgLevel                                            //机构等级

//    @Column(dict = "enable_status")
    int enabled                        //是否有效
    Date registerTime                            //注册时间
    Date invalidTime                            //失效时间

    @Column(size = 24)
    String phone                                //电话
    @Column(size = 40)
    String password                                //密码（加密）

    int status = 0                                //状态

    @Column(size = 24, unique = true)
    String uniqueId                                //唯一编码

//    @Column(dict = "country")
    int country = 0                                //国家
    @Column(size = 96)
    String email                                //邮箱
    @Column(size = 160)
    String address                                //地址
    @Column(size = 128)
    String name                                    //名称

//    @Column(dict = "province", columnName = 'province')
    int province = 0                            //省份


    @Column(size = 255)
    String description                            //描述

//	Photo photo									//相片

    @Column(size = 128)
    String fullName

    Organization parent                                    //上级单位
    boolean isIssuer = false                                //对应上游通道
    boolean isAgent = false                                    //代理
    boolean isInternal = false                            //是否为渠道接入，结算给一级代理
    Organization clearParent                                //清算主体，渠道接入时生效
    boolean useCreditDeposit = false                        //是否使用保证金充值
    boolean isMerchant = false  //是否是商户

    @Column(size = 20)

    /**
     * p200,p300,p400,p500,p600,p700
     * 用来提高查询效率
     * 如：山东省公司orgLevel是300，id是3，那么山东省公司的所有下级单位的p300字段都会保存山东省公司的id值3
     * 查询山东省下辖所有机构时可以根据p300进行查询
     */
    Long p1, p200, p300, p400, p500, p600, p700, p800

    /////////////////////////////////////////
    @Column(size = 16, index = true)
    String cardUnique

    @Column(size = 64, index = true)
    String oldUniqueId;

//    @Column(dict = "org_status")
//    int orgStatus = OrgStatus.OK

    @Column(size = 24)
    String idno
    Date idExpireDate    //有效期限


    public void preUpdate(boolean isNew) {
        if (idno) {
            idno = idno.toUpperCase()
        }
        assert name: X("PREUPDATE_ORGANIZATION_NAME")
        assert name.getBytes().length < 120: "机构名称过长,不能超过60个汉字"

        if (isNew) {

        } else {
            def oldUniqueId = ejbService.tx.loadByStmt("select uniqueId from Organization where id=?", this.id)
            assert !oldUniqueId || uniqueId == oldUniqueId: "不能改变机构编号";

            //先设置所有机构清算主体都是自己，结算给代理商的后续代码会覆盖该设置
            clearParent = this;
        }

        int orgUniqueIdLength = partyService.getOrgUniqueIdLength()

        if (!uniqueId) {
            String tmp = orgUniquePrefix +
                    ('0000') +
                    sequenceService.getContinuousStr("", '0000000', 'orgUnique')
            uniqueId = tmp
        }

        /*  if (name) {
              def a = Organization.loadByName(name)
              assert !a || a.id == id: X("PREUPDATE_ORGANIZATION_ISUNIQUEID", name)
          }*/

        // 如果是根单位，不作任何检查
        if (isRoot()) {
            def root = Organization.loadByParent(null)
            assert !root || root == this: X("PREUPDATE_ORGANIZATION_ROOT")
            orgLevel = OrgLevel.HQ
        } else {
//        	println parent;
            assert dictService.getItem("org_level", orgLevel): X("PREUPDATE_ORGANIZATION_ORGLEVEL", orgLevel)
            assert parent.orgLevel < orgLevel: X("PREUPDATE_ORGANIZATION_PARENT_ORGLEVEL")
            def p = parent

            //更新上级机构id
            while (p) {
                setProperty("p" + p.orgLevel, p.id)
                p = p.parent;
            }
            super.preUpdate(isNew)
        }
    }

    public void postUpdate(boolean isNew) {
        setProperty("p" + orgLevel, id)

        //代理机构的清算主体一定是自己
        if (isNew && isAgent) {
            clearParent = this;
        }
        super.postUpdate(isNew)
    }

    public void preRemove() {

    }

    public boolean isRoot() {
        return !parent
    }

    /**
     * 是否为父单位
     */
    boolean isParent(def child) {
        if (child == this) return false
        if (orgLevel == 1) return true
        return child.getProperty('p' + orgLevel) == id
    }

    /**
     * 是否为父单位或相等
     */
    boolean isParentOrSame(def child) {
        if (child == this) return true
        return isParent(child)
    }


    public Object clone() {
        def obj = null;
        try {
            obj = super.clone();
            obj.id = null;
            obj.version = 0;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }


}
