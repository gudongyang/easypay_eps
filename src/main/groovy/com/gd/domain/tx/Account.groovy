package com.gd.domain.tx

import com.gd.domain.party.Organization
import com.gd.magic.anno.Column


class Account extends com.gd.magic.RootEntity {
    static int idLength = 8

    /** 余额*/
    long balance

    /**下限*/
    long lowLimit

    /** 帐户类型 */
//    @Column(dict = "account_type", notNull = true, index = true)
    int type

    /** 状态 */
//    @Column(dict = "account_status", notNull = true)
    int status

    /** 最后交易时间  */
    Date lastCardTime

    /** 失效时间 */
    Date expiredDate

    /** 用于校验数据的mac字符串*/
    @Column(size = 8)
    String mac

    /**
     * Issuer
     * 发卡机构
     */
    Organization issuer

    /** 剩余收益，未提现收益*/
    long lastestIncome;

    /** 累计收益*/
    long totalIncome;

    /**冻结金额*/
    long freezeAmt = 0

    /**创建时间*/
    Date createTime;

    /**
     * 是否允许退款,提现
     */
    boolean canWithdraw = true


    public void preUpdate(boolean isNew) {
        assert balance >= lowLimit: X('账户余额不足');
        //assert lastestIncome>=0: "未支付收益不能小于0";
        if (isNew) {
            //设置account的issuer
            if (type == UserAccountType.PERSONAL) {
                issuer = user.regOrg;
            } else {
                issuer = Organization.loadByOrgLevel(OrgLevel.HQ)
            }
            assert issuer: X('TX_ACCOUNT_NO_ISSUER')
            status = AccountStatus.NORMAL;
            createTime = new Date();
            canWithdraw = true
        }
//	  		else{
//	  			mac = accountService.vedifyAccount(this, false)	//生成mac
//	  		}
        super.preUpdate(isNew)
    }

//		public void postUpdate(boolean isNew) {
//			if (isNew){
//				mac = accountService.vedifyAccount(this, false)	//生成mac
//			}
//		}

    public int getAccountType() {
        return type;
    }
}