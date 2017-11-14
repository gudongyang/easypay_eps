function ServiceUrl() {
}
ServiceUrl.DWR = "d/dwr/";
ServiceUrl.LIST = "d/list/";
ServiceUrl.CROSSTAB = "d/crosstab/";
ServiceUrl.BILL = "d/bill/";
ServiceUrl.UPLOAD_PHOTO = "d/upload/photo";
ServiceUrl.UPLOAD_PRODUCTIONFILE = "d/upload/productionFile";
ServiceUrl.PHOTO = "d/photo";
ServiceUrl.IMPORTDATA = "d/importdata";

function initStr(s, len) {
    var str = ""
    for (var i = 0; i < len; i++) {
        str += s;
    }
    return str
}

function Constants() {
}

Constants.DEFPIN = "123456";
function initGoodsLimit(len) {
    var str = initStr("F", 8);
    var res = "";
    for (var i = 0; i < len; i++) {
        if (res) res += ";";
        res += str;
    }
    return res
}


Constants.OIL_FULL = initGoodsLimit(8);
Constants.MER_FULL = initGoodsLimit(15);


Constants.ORG_LEVEL = [1, 200, 500, 700];		//数组列表
Constants.ORG_LEVEL_HQ = 1;				//总部
Constants.ORG_LEVEL_PROVINCE = 200;		//省大区
Constants.ORG_LEVEL_CITY = 500;			//地市
Constants.ORG_LEVEL_STATION = 700;		//加油站

Constants.CARD_BILL_TYPE_IN = 1;			//卡片入库单
Constants.CARD_BILL_TYPE_OUT = 2;			//卡片出库单
Constants.CARD_BILL_TYPE_ADJUST = 3;		//库存调整单

Constants.LOG_TYPE_CARD = 1							//card
Constants.LOG_TYPE_CARDBILL = 2						//卡片出库单
Constants.LOG_TYPE_CARDREQUEST = 3					//卡片申请单

Constants.CARDBILL_STATUS_NEW = "1";								//新建
Constants.CARDBILL_STATUS_PASSAGE = "2";							//在途
Constants.CARDBILL_STATUS_ACCPECTED = "3";						//已接收
Constants.CARDBILL_STATUS_CANCELED = "9";						//被撤销
Constants.CARDBILL_STATUS_CANCEL = "99";							//撤销
Constants.CARDBILL_STATUS_REQUEST = "101";						//申请
Constants.CARDBILL_STATUS_PASSED = "102"							//通过
Constants.CARDBILL_STATUS_REJECTED = "103"						//拒绝
Constants.CARDBILL_STATUS_CONFIRM = "201"						//确认

Constants.TRADE_TYPE_CASH_IN = 100;     					//现金充值
Constants.TRADE_TYPE_CHEQUE_IN = 101;						//支票充值
Constants.TRADE_TYPE_BANK_IN = 102;     					//银行卡充值
Constants.TRADE_TYPE_ACCUMULATE = 103;					//累积（后台自动充值）
Constants.TRADE_TYPE_RET_CLIENT = 104;					//中心偿还
Constants.TRADE_TYPE_CASH_OUT = 110;     					//退现金
Constants.TRADE_TYPE_CHEQUE_OUT = 111;					//退支票
Constants.TRADE_TYPE_BANK_OUT = 112;     					//退银行卡
Constants.TRADE_TYPE_EXPIRE = 113;     					//失效
Constants.TRADE_TYPE_CLEAR = 114;     					//销户清零
Constants.TRADE_TYPE_TRANSFER_IN = "120";     				//转帐
Constants.TRADE_TYPE_TRANSFER_OUT = "121";     				//转帐
Constants.TRADE_TYPE_ORG_DIST_IN = "122";     				//单位客户分配
Constants.TRADE_TYPE_ORG_DIST_OUT = "123";     				//单位客户分配
Constants.TRADE_TYPE_ORG_COLLECT_IN = "124";     			//单位客户汇总
Constants.TRADE_TYPE_ORG_COLLECT_OUT = "125";     			//单位客户汇总
Constants.TRADE_TYPE_CREDIT_DEPOSIT_IN = "126";     		//保证金转帐
Constants.TRADE_TYPE_CREDIT_DEPOSIT_OUT = "127";     		//保证金转帐
Constants.TRADE_TYPE_CREDIT_WITHDRAW_IN = "128";     		//保证金退还
Constants.TRADE_TYPE_CREDIT_WITHDRAW_OUT = "129";     		//保证金退还
Constants.TRADE_TYPE_CARD_CONSUME = 150;     				//IC卡消费
Constants.TRADE_TYPE_SPARE_CONSUME = "151";     			//备用金消费
Constants.TRADE_TYPE_CASH_CONSUME = "152";     				//现金消费
Constants.TRADE_TYPE_BANK_CONSUME = 153;     				//银行卡消费
Constants.TRADE_TYPE_BANK_DEPOSIT = 154;     				//银行卡代充值
Constants.TRADE_TYPE_POINT_EXCHANCE = 155;     				//积分兑换
Constants.TRADE_TYPE_LOAD_IN = "160";     					//圈存
Constants.TRADE_TYPE_LOAD_OUT = "161";     					//圈存
Constants.TRADE_TYPE_UNLOAD_IN = "162";     				//圈提
Constants.TRADE_TYPE_UNLOAD_OUT = "163";     				//圈提
Constants.TRADE_TYPE_CARD_RETURN_IN = "164";     			//卡转备用金
Constants.TRADE_TYPE_CARD_RETURN_OUT = "165";     			//卡转备用金

Constants.PAYMENT_CASH = "1"; 				//现金
Constants.PAYMENT_CHEQUE = "2";				//支票
Constants.PAYMENT_BANK = "3";				//银行卡

Constants.TRADE_STATUS_NORMAL = 1; 			//正常(交易状态)
Constants.TRADE_STATUS_TEMP = 4; 			//临时交易
Constants.TRADE_STATUS_CANCEL = 5; 			//撤销
Constants.TRADE_STATUS_CANCELED = 6; 		//被撤销
Constants.TRADE_STATUS_BOOKING = 7; 		//预约
Constants.TRADE_STATUS_INVALIDITY = 8; 		//失效
Constants.TRADE_STATUS_GOODSRETURN = 10; 	//退货

Constants.BLANK_CARD_TYPE_BLANK = "1";					//白卡卡片白卡类型
Constants.BLANK_CARD_TYPE_PSAM = "2";					//白卡卡片PSAM卡片类型

Constants.CLEAR_STAT_DYNA = "dyna";						//查询报表
Constants.CLEAR_STAT_DAY = "day";						//日表
Constants.CLEAR_STAT_MONTH = "month";					//月表
Constants.CLEAR_STAT_YEAR = "year";						//年表

Constants.SELORG_ALL = "1";								//全部子节点
Constants.SELORG_CHILDREN = "2";						//直属子节点

Constants.CERTIFICATE_TYPE_PEOPLE = "1";				//身份证
Constants.CERTIFICATE_TYPE_OFFICER = "2";				//军官证
Constants.CERTIFICATE_TYPE_PASSPORT = "3";				//护照
Constants.CERTIFICATE_TYPE_LICENSE = "4";				//营业执照

Constants.GIFT_ORDER_TYPE_PLAN = "1";                              //礼品申请单
Constants.GIFT_ORDER_TYPE_BLANKPLAN = "2";                         //礼品退货申请单
Constants.GIFT_INVENTORY_IN = "1";                                //礼品验证入库单
Constants.GIFT_INVENTORY_IN_GIVE = "2";                            //领奖出库单
Constants.GIFT_INVENTORY_TYPE_BLANKPOUT = "3";                    //礼品退货出库
Constants.GIFT_INVENTORY_reject = "4";                              //礼品报废单
Constants.GIFT_INVENTORY_IN_CORRECT = "5";                        //礼品入库更正单

Constants.REQUEST_LOWEST_LEVEL = "500"							//最低申请级别

Constants.ACCOUNT_FEE_SELL_CARD = "2101";			//售卡手续费帐户
Constants.ACCOUNT_FEE_CHANGE_CARD = "2102";			//换卡手续费帐户
Constants.ACCOUNT_FEE_RENEW_CARD = "2103";			//补卡手续费帐户
Constants.ACCOUNT_FEE_REVOCATE_CARD = "2104";		//销户手续费
Constants.ACCOUNT_FEE_CUSTOMIXE_CARD = "2105";		//定制卡片手续费帐户
Constants.ACCOUNT_FEE_REPORTLOCK_CARD = "2106";		//挂失手续费帐户
Constants.ACCOUNT_FEE_UNLOCK_CARD = "2107";			//解挂手续费帐户
Constants.ACCOUNT_FEE_EXPIRED_CARD = "2108";		//失效卡手续费帐户
Constants.ACCOUNT_FEE_UPGRAD_ANON_CARD = "2109";	//不记名卡升级手续费帐户
Constants.ACCOUNT_FEE_DRIVER_UPGRAD_CARD = "2110";	//副卡升级手续费帐户
Constants.ACCOUNT_FEE_RESET_PIN_CARD = "2111";		//重置密码手续费帐户
Constants.ACCOUNT_FEE_USE_PIN_CARD = "2112";		//启用停用密码手续费帐户


Constants.ACCOUNT_FOREGIFT_CARD = "2201";		//卡押金帐户

Constants.CUSTOMERLEVEL_NORMAL = 1;

//发卡类型标志
Constants.ANONYMOUS = 1;		//不记名卡
Constants.COMPANY = 2;			//单位卡
Constants.PERSONAL = 3;			//个人卡
Constants.OPERATOR = 4;			//操作员卡
Constants.PSAM = 5;				//PSAM卡


Constants.SPARE_ACCOUNT_PREFIX = "user_";//备用帐户的前缀
Constants.CARD_ACCOUNT_PREFIX = "card_";//卡帐户的前缀

var BaseCardType = {
    CATEGORY: "base_card_type",
    PERSONAL: 1,		//个人卡
    COMPANY: 2,		//单位卡
    PSAM: 3,			//PSAM卡
    OPERATOR: 4,		//操作员卡
    UKEY: 5        	//UKey
}

var BaseCardTypeCode = {}
BaseCardTypeCode[BaseCardType.PERSONAL] = 90;
BaseCardTypeCode[BaseCardType.COMPANY] = 91;
BaseCardTypeCode[BaseCardType.PSAM] = 98;
BaseCardTypeCode[BaseCardType.OPERATOR] = 99;
BaseCardTypeCode[BaseCardType.UKEY] = 10;

var BlankCardType = {
    USER: 1,				//CPU卡
    PSAM: 2,				//PSAM卡
    MF1: 3,			//MF1卡
    MAGNETIC: 4			//磁条卡
}
var CardStoreStatus = {
    CATEGORY: "cardstore_status",
    MANUFACTURE: 1,		//制卡
    STORE: 2,				//库存
    ONPASSAGE: 3,			//在途
    IN_USE: 4,				//流通
    LOST: 5,				//丢失
    DAMAGED: 6,			//损坏
    DESTORYED: 99			//销毁
}

var CardStatus = {
    CATEGORY: "card_status",
    OK: 2,				//正常状态
    BLACK: 3,			//黑名单状态
    REVOCATION: 4,		//注销状态
    NOCARD: 5, 			//无卡注销状态
    INITED: 7	 			//预个人化状态
}

var CardUserType = {
    CATEGORY: "carduser_type",
    NAME: 1, 		//card_user中的type类型为个人帐户
    COMPANY: 2,	//card_user中的type类型为单位帐户
    DRIVER: 3		//card_user中的type类型为司机卡帐户
}

var AccountType = {
    FUND: 1,				//资金
    POINT: 2,				//积分
    INTEREST: 3,			//利息
    CREDIT: 9,				//信用帐户
    FEE_SELL_CARD: 2101,	//售卡手续费
    FEE_RESELL_CARD: 2102,	//补卡手续费
    FOREGIFT_CARD: 2201	//卡押金
}

var SubAccountType = {
    SPARE: 1,				//备用金帐户
    CARD: 2				//卡帐户
}
var AccountUnit = {
    RMB: 1,			//元
    POINT: 2			//分
}

var CardBillType = {
    CATEGORY: "cardbill_type",
    IN: 1,					//入库单
    OUT: 2,					//出库单
    ADJUST: 3					//库存调整单
}

var CardBillStatus = {					//出库单 申请单 制卡任务单
    CATEGORY: "CARDBILL_STATUS",
    NEW: 1,			//新建		*	*	*
    PASSAGE: 2,		//在途		*
    ACCPECTED: 3,		//已接收		*
    CANCELED: 9,		//被撤销		*	*
    CANCEL: 99,		//撤销		*
    REQUEST: 101,		//申请		*	*
    PASSED: 102,		//通过		*	*
    REJECTED: 103,		//拒绝		*	*
    CONFIRM: 201,			//确认				*
    DELETED: 999			//删除
}

var CardBillSubType = {
    CATEGORY: "cardbill_subtype",
    IN_MANUFACTURE: 101,		//制卡后入库
    IN_INTERNAL: 102,			//内部流转入库
    IN_BUSINESS: 103,			//业务入库
    OUT_INTERNAL: 201,			//内部流转出库
    OUT_BUSINESS: 202,			//业务出库
    ADJUST_STOCK: 301,			//在库调整
    ADJUST_ONPASSAGE: 302		//在途调整
}
var BlankCardBillSubType = {
    CATEGORY: "blankcardbill_subtype",
    ADJUST_BLANK_LOST: 301,		//丢失
    ADJUST_BLANK_DAMAGED: 302		//损坏
}
var CardUserStatus = {
    CATEGORY: "carduser_status",

    UNACTIVATED: 1,	//card_user中的status为未激活状态
    OK: 2,				//card_user中的status为正常状态
    BLACK: 3,			//card_user中的status为黑名单状态
    REVOCATION: 4,		//card_user中的status为注销状态
    CUSTOMIZE: 5		//card_user中的status为定制状态
}

var MgntOtherConstant = {
    CARD_BLACKTYPE_OFFICIAL: 1,	//card中的黑名单类型为正式挂失
    CARD_BLACKTYPE_TEMP: 2,		//card中的黑名单类型为临时挂失
    //CARD_BLACKTYPE_REVOCATION : 3,//card中的黑名单类型为无卡注销
    CARD_BLACKTYPE_ADMIN: 5,		//card中的黑名单类型为管理员冻结
    CARD_BLACKTYPE_BAD: 7,		//card中的黑名单类型为坏卡登记
    CARD_BLACKTYPE_ORG: 8 		//card中的黑名单类型为单位冻结
}

var AuditCategory = {

    SYSTEM: 1,			//系统
    CARDUSER: 2 		//卡用户
}

var AuditStatus = {
    CATEGORY: "audit_status",

    OPEN: 1,			//等待验证
    PASSED: 2, 		//审核通过
    REJECTED: 11		//未通过
}


var AccountStatus = {
    NORMAL: 1, 		//帐户为正常状态
    PRE_EXPIRED: 2, 	//帐户为预失效状态
    EXPIRED: 3 		//帐户为失效状态
}

var ChequeStatus = {
    OPEN: 10,
    COUNTERCANCEL: 11,
    VALIDITY: 20,
    INVALIDITY: 21,
    AMOUNTWRONG: 22
}
var ExchangeRateStatus = {
    OK: 1,				//生效
    INVALIDITY: 2,		//失效
    INITED: 3			//预生效
}
var ExchangeRateType = {
    RMB: 1,				//澳元
    PATACA: 2,				//澳元
    DOLLAR: 3				///美元
}
var Currency = {
    RMB: 1,				//澳元
    PATACA: 2,				//澳元
    DOLLAR: 3				///美元
}
var BaseAccountType = {
    NORMAL: 1,		//普通
    SETTLEMENT: 2,		//结算
    FEE: 3				//手续费、押金
}
var EpsTradeType = {
    CARD: 10,
    BANK: 11,
    CASH: 12,
//	CANCEL:13,
    UNGRAY: 15
}

var PageType = {
    SEL_DRIVER: "selDriver",													//选择司机
    UPDATE_ANON_CARD: "update_anon_card",										//不记名卡升级
    CHANGE_CARD: "change_card",												//换卡
    REVOCATE_CARD: "revocate_card",											//有卡销卡
    CREATE_PERSONAL: "person_create",
    CREATE_COMPANY: "acc_create",
    ISSUECARD_SELUSER: "issue_card-acc_person_manage",
    ISSUECARD_CREUSER: "issue_card-person_create"
}

var GoodsType = {
    CATEGORY: "goods_type",
    FUEL: 1,				//油品
    NON_FUEL: 2			//非油品
}

var StatClass = {//报表类型
    Acquirer: 1,
    BenDaiTa: 2,
    TaDaiBen: 3,
    Headquarter: 4,			//总部报表
    Org: 5					//本地受理
}

var InvoiceType = {
    CATEGORY: "invoice_type",
    CONSUME: 1,
    DEPOSIT: 2,
    VAT: 3,
    DEPOSIT_BACK: 12
}

var BlankCardBillStatus = {
    CATEGORY: "commonbill_status",
    COMMON_OK: 1,				//正常
    COMMON_CANCELED: 2,		//被撤销状态
    COMMON_CANCEL: 3			//撤销状态
}

var ErrorType = {
    TAC_ERROR: 4, 			//TAC错误
    CARDASN_ERROR: 6, 		//卡号错误
    TRADETYPE_ERROR: 7, 	//消费类型错误
    PSAMASN_ERROR: 8, 		//PSAM卡号错误
    ACCTYPE_ERROR: 9, 		//帐户类型错误
    PSAM_NO_TMATCH: 12,		//Psam卡和站点不对应
    BALANCE_ERROR: 13,		//卡余额异常
    WRONG_BANK_ISSUER: 16,	//错误的银行接入节点号
    TIME_ERROR: 17,			//时间错误
    AMOUNT_EERROR: 18,		//交易金额异常
    MANUAL_ADD: 20 		//清算调整的撤销交易
}
var MatchResultStatus = {
    UNINIT: 1 				//未处理
//	,EPS_UNMATCH : 2 		//EPS不平
    , EPS_OK: 3 			//EPS已上传
    , HOS_WAIT: 4			//等待HOS对帐
    , HOS_UNMATCH: 5		//HOS不平
    , HOS_OK: 6				//HOS平
}
var DailyCheckStatus = {
    UNCHECKED: 1,	//未复核
    CHECKED: 2,		//已复核

    ONLINE_INIT: 10,
    ONLINE_CHECKED: 11,
    ONLINE_MISS: 12,
    ONLINE_OK: 13
}
var DailyCheckType = {
    ONLINE: 1,				//充值点联机复核
    OFFLINE: 2,			//加油站复核
    ONLINE_CITY: 11,		//地市联机复核
    OFFLINE_CITY: 12		//地市脱机复核
}
var ShiftStatus = {
    INITIAL: 1,
    CONFIRM_OPENING: 2,
    CONFIRM_CLOSING: 3
}
var PeriodStatus = {
    OPEN: 1,				//当前帐期
    AUTO_CLOSED: 10,		//自动关闭
    MANUAL_CLOSED: 11	//手工关闭
}
var UserLevel = {
    CATEGORY: "user_level",
    NORMAL: 1
}

var RuleCategory = {
    CATEGORY: "rule_category",
    SERVICEFEE: 1,				//业务手续费
    POINT: 2,					//积分规则
    LOYALTY: 3,				//忠诚度规则
    DISCOUNT: 4,				//折扣规则

    DISCOUNT_DEPOSIT: 40100,	//充值折扣
    DISCOUNT_PURCHASE: 40150	//消费折扣
}


var RuleDataType = {
    NUMBER: 1,				//数值
    STRING: 2,				//字符串
    DATE: 3,				//时间
    BOOLEAN: 4,			//布尔值

    DICT: 10,				//字典
    ENTITY: 11,			//Entity
    CURRENCY: 12			//金额
}

var RuleType = {
    CARDFEE: 12101,				//业务手续费

    DISCOUNT_DEPOSIT: 40100,	//充值折扣
    DISCOUNT_PURCHASE: 40150	//消费折扣
}

var RuleStatus = {
    CATEGORY: "rule_status",
    NORMAL: 1,				//正常
    REQUEST: 2,					//申请
    DECLNED: 3,				//拒绝
    CANCELED: 4,				//撤销
    DRAFT: 5				//草稿

}
