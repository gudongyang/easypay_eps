package com.gd.domain.party;

/**
 * 本类提供交易用到的OrgLevel字典项的常量定义
 *
 * @copyright ( c ) Copyright G&D Corporation 2007.
 * @author wangchunxian
 * @since v0.2
 */
class OrgLevel {
    static final CATEGORY = "org_level";
    public static int HQ = 1                        //总部级
    public static int PROVINCE = 200                //一级代理
    public static int CITY = 500                    //二级代理
    public static int STATION = 700                    //三级代理
    public static int MERCHANT = 800                //商户
}