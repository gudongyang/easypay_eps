package com.gd.domain.mobile

import cn.test.Test
import com.enett.ws.client.*
import com.gd.magic.anno.Service
import com.gd.magic.util.FormatUtil
import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import javax.net.ssl.SSLContext
import javax.xml.rpc.ServiceException

/**
 * @author dy_gu king.gu@gmail.com
 * @version V1.0
 * @date 2017/10/15 下午1:03
 * @Copyright: 2017 wepay.mpay.cn Inc. All rights reserved.
 */
class ENettService implements com.gd.magic.Service {


    private static Log log = LogFactory.getLog(Test.class);

    public static String accessKey = "Dn82Gmw3FSr1g7R5";//"y4M2HfTz5b0J9QpX";// "";


    static String integratorCode = "EASYPAYDEMO";
    static String integratorAccessKey = "djsp0Adijh1hGPBxk9F57zHu72qIP4LDZNkFVtK3TUgA8hD8MEBART1KVBL7DdfW";
    static int requesterECN = 500429;

    static int clientECN = 500429;//requesterECN;

    static String username = "TFALLA";

    private static BasicHttpBinding_IvNettServiceV2Stub binding;

    static {
        //启动java1.7 de TLS1.2 默认1.0
        //jdk1.8 不用这样处理
        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
        ctx.init(null, null, null);
        SSLContext.setDefault(ctx);
    }


    static {
        try {
            binding = (BasicHttpBinding_IvNettServiceV2Stub) new VNettServiceV2Locator()
                    .getBasicHttpBinding_IvNettServiceV2();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        // Time out after a minute
        binding.setTimeout(30000);


    }

    @Service(dwr = true)
    def test() {
        Test.getFxQuote()
        Test.issueVAN()
    }

    /**
     * 请求虚拟账户
     * @param activationDate
     * @param expiryDate
     * @param maximumAuthorisationAmount
     * @param multiUseClosePercentage
     * @param merchantCategoryName
     * @param integratorReference
     * @param notes
     * @return
     */
    def issueVANInf(Date activationDate,
                    Date expiryDate,
                    int maximumAuthorisationAmount,
                    int multiUseClosePercentage,
                    String merchantCategoryName,
                    String integratorReference,
                    String notes
    ) {


        def ret = issueVAN("HK",
                "HKD",
                FormatUtil.format("yyyyMMdd", activationDate),
                FormatUtil.format("yyyyMMdd", expiryDate),
                true,
                multiUseClosePercentage,
                0,
                maximumAuthorisationAmount,
                merchantCategoryName,
                notes,
                integratorReference,
                "MASTERCARD")

        return ret

    }

    /**
     *
     * @param countryCode
     * @param currencyCode
     * @param activationDate
     * @param expiryDate
     * @param isMultiUse
     * @param multiUseClosePercentage
     * @param minimumAuthorisationAmount
     * @param maximumAuthorisationAmount
     * @param merchantCategoryName
     * @param notes
     * @param integratorReference
     * @param cardTypeName
     * @return
     */
    @Service(dwr = true)
    def issueVAN(String countryCode,
                 String currencyCode,
                 String activationDate,
                 String expiryDate,
                 boolean isMultiUse,
                 int multiUseClosePercentage,
                 int minimumAuthorisationAmount,
                 int maximumAuthorisationAmount,
                 String merchantCategoryName,
                 String notes,
                 String integratorReference,
                 String cardTypeName) {

//        countryCode = "HK"; //国家地区编码
//        currencyCode = "HKD"; //货币编码
//        activationDate = "20171111";
//        expiryDate = "20181111";
//        isMultiUse = true; //是否支持多次使用
//        multiUseClosePercentage = 95; //多次使用上线
//        minimumAuthorisationAmount = 0; //IsMultiUse 为true时固定是0
//        maximumAuthorisationAmount = 100000;
//        merchantCategoryName = "AIRLINE"; //有條件的（如果MCC欄位已填充，則不需要）來自預定義清單。


        IssueVANRequest issueVANRequest = new IssueVANRequest();
        issueVANRequest.setIntegratorCode(integratorCode);
        issueVANRequest.setIntegratorAccessKey(integratorAccessKey);
        issueVANRequest.setRequesterEcn(requesterECN);
        int issuedToEcn = requesterECN;
        issueVANRequest.setIssuedToEcn(issuedToEcn);

        issueVANRequest.setUsername(username);

        System.out.println("integratorReference: ${integratorReference}");

        issueVANRequest.setIntegratorReference(integratorReference);

//        issueVANRequest.setCountryCode("HK");//
        issueVANRequest.setCountryCode(countryCode);//
//        String currencyCode = "HKD";

        issueVANRequest.setCurrencyCode(currencyCode);

        issueVANRequest.setCardTypeName(cardTypeName);

//        int minimumAuthorisationAmount = 0; //IsMultiUse 为true时固定是0
        issueVANRequest.setMinimumAuthorisationAmount(minimumAuthorisationAmount);
//        int maximumAuthorisationAmount = 100000;
        issueVANRequest.setMaximumAuthorisationAmount(maximumAuthorisationAmount);

//        String activationDate = "20171111";
        issueVANRequest.setActivationDate(activationDate);
//        issueVANRequest.setExpiryDate("20181111");
        issueVANRequest.setExpiryDate(expiryDate);
        issueVANRequest.setIsInstantAuthRequired(false);

        issueVANRequest.setIsMultiUse(isMultiUse);
//        issueVANRequest.setIsMultiUse(true);
//        issueVANRequest.setMultiUseClosePercentage(95);
        issueVANRequest.setMultiUseClosePercentage(multiUseClosePercentage);
        issueVANRequest.setMerchantCategoryName(merchantCategoryName);
        issueVANRequest.setFundingCurrencyCode(currencyCode);
        issueVANRequest.setNotes(notes);


        String messageDigest = calcMac([
                integratorReference,
                activationDate,
                cardTypeName,
                currencyCode,
                issuedToEcn + "",
                maximumAuthorisationAmount + "",
                minimumAuthorisationAmount + "",
                merchantCategoryName,
                notes,
                username
        ]);
        issueVANRequest.setMessageDigest(messageDigest);
        IssueVANResponse issueVANResponse = binding.issueVAN(issueVANRequest);

        def retMap = [
                "Successful"          : issueVANResponse.getIsSuccessful(),
                "errorCode"           : issueVANResponse.getErrorCode(),
                "ErrorDescription"    : issueVANResponse.getErrorDescription(),
                "SupportLogID"        : issueVANResponse.getSupportLogId(),
                "vNettTransactionID"  : issueVANResponse.getVNettTransactionID(),
                "VirtualAccountNumber": issueVANResponse.getVirtualAccountNumber(),
                "ExpiryDate"          : issueVANResponse.getExpiryDate(),
                "FullExpiryDate"      : issueVANResponse.getFullExpiryDate(),
                "CardSecurityCode"    : issueVANResponse.getCardSecurityCode(),
                "CardholderName"      : issueVANResponse.getCardHolderName(),
                "GenerationDate"      : issueVANResponse.getGenerationDate(),
                "ActivationDate"      : issueVANResponse.getActivationDate(),
                "MinimumAuthAmount"   : issueVANResponse.getMinimumAuthorisationAmount(),
                "MaximumAuthAmount"   : issueVANResponse.getMaximumAuthorisationAmount(),
                "FundedAmount"        : issueVANResponse.getFundedAmount(),
                "CurrencyCode"        : issueVANResponse.getCurrencyCode(),
                "FundingCurrencyCode" : issueVANResponse.getFundingCurrencyCode(),
                "FXRate"              : issueVANResponse.getFxRate(),
                "RCNAlias"            : issueVANResponse.getRCNAlias(),
                "RCNDescription"      : issueVANResponse.getRCNDescription(),
                "SafetyMargin"        : issueVANResponse.getSafetyMargin(),
                "AccountID"           : issueVANResponse.getAccountId(),
        ];
        System.err.println("retMap:" + retMap);

//        errCode	Number(2)	交易状态 00 交易成功状态。98 单号重复。 别的状态都要通过代付查询接口确认	YES	00
//        errCodeDes	String(40)	交易状态描述	YES	单笔代付提交成功


        String errCode = issueVANResponse.getErrorCode();



        return [
                "virtualAccountNumber": issueVANResponse.getVirtualAccountNumber(),
                "expiryDate"          : issueVANResponse.getExpiryDate(),
                "fullExpiryDate"      : issueVANResponse.getFullExpiryDate(),
                "cardSecurityCode"    : issueVANResponse.getCardSecurityCode(),
                "cardholderName"      : issueVANResponse.getCardHolderName(),
                "generationDate"      : issueVANResponse.getGenerationDate(),
                "activationDate"      : issueVANResponse.getActivationDate(),
                "maximumAuthAmount"   : issueVANResponse.getMaximumAuthorisationAmount(),
                "errCodeDes"          : issueVANResponse.getErrorDescription(),
                "errCode"             : errCode == "0" ? "00" : errCode
                //"FundedAmount":issueVANResponse.getFundedAmount(), //從客戶可用餘額中扣除的金額，以要求中提出的充值貨幣表示。
//                "CurrencyCode"        : issueVANResponse.getCurrencyCode(),
//                "FundingCurrencyCode" : issueVANResponse.getFundingCurrencyCode()


        ];
//        retMap:["Successful":true, "errorCode":0, "ErrorDescription":null, "SupportLogID":null, "vNettTransactionID":1616211, "VirtualAccountNumber":"5578955002214100", "ExpiryDate":"11/2018", "FullExpiryDate":"20181111", "CardSecurityCode":"176", "CardholderName":"Easy Pay Demo", "GenerationDate":"20171023", "ActivationDate":"20171111", "MinimumAuthAmount":0, "MaximumAuthAmount":100000, "FundedAmount":0, "CurrencyCode":"HKD", "FundingCurrencyCode":"HKD", "FXRate":1, "RCNAlias":null, "RCNDescription":null, "SafetyMargin":0, "AccountID":null]
        //integratorReference: 1508814796744
        //retMap:["Successful":true, "errorCode":0, "ErrorDescription":null, "SupportLogID":null, "vNettTransactionID":1618239, "VirtualAccountNumber":"5578955001387980", "ExpiryDate":"11/2018", "FullExpiryDate":"20181111", "CardSecurityCode":"536", "CardholderName":"Easy Pay Demo", "GenerationDate":"20171024", "ActivationDate":"20171111", "MinimumAuthAmount":0, "MaximumAuthAmount":100000, "FundedAmount":0, "CurrencyCode":"HKD", "FundingCurrencyCode":"HKD", "FXRate":1, "RCNAlias":null, "RCNDescription":null, "SafetyMargin":0, "AccountID":null]
    }

    /*
    * 取消VAN
    * */

//    public static final String _BookingCancelled = "BookingCancelled";
//    public static final String _BookingAmended = "BookingAmended";
//    public static final String _DuplicateRequest = "DuplicateRequest";
//    public static final String _ErrorInOriginalRequest = "ErrorInOriginalRequest";
//    public static final String _CreditLimitUpdateFailed = "CreditLimitUpdateFailed";
//    public static final String _MaximumToleranceExceeded = "MaximumToleranceExceeded";
//    public static final String _FundingFailed = "FundingFailed";
//    public static final String _FraudulentUse = "FraudulentUse";
//    public static final String _PossibleFraudulentUse = "PossibleFraudulentUse";




    Map<String,String> type2str = [Booking_Cancelled        : "BookingCancelled",
                    Booking_Amended          : "BookingAmended",
                    Duplicate_Request        : "DuplicateRequest",
                    Error_In_Original_Request: "ErrorInOriginalRequest",
                    Fraudulent_Use           : "FraudulentUse",
                    Possible_Fraudulent_Use  : "PossibleFraudulentUse"]

    @Service(dwr = true)

    def cancelVAN(String cancelReasonStr,
                  String integratorReference) {

//        integratorReference = "1508814796744";
//        cancelReasonStr = "BookingCancelled";
        CancelReasonType cancelReason = null;


        try {
            cancelReason = CancelReasonType.fromString(type2str.get(cancelReasonStr));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            assert false: "IllegalArgument of cancelReason, 取消原因不正确"
        }

        CancelVANRequest cancelVANRequest = new CancelVANRequest();
        cancelVANRequest.setIntegratorCode(integratorCode);
        cancelVANRequest.setIntegratorAccessKey(integratorAccessKey);
        cancelVANRequest.setRequesterEcn(requesterECN);

        int issuedToEcn = requesterECN;
        cancelVANRequest.setIssuedToEcn(issuedToEcn)
        cancelVANRequest.setUsername(username);

//        String integratorReference = System.currentTimeMillis() + "";
        cancelVANRequest.setIntegratorReference(integratorReference);
        cancelVANRequest.setCancelReason(cancelReason);


        String messageDigest = calcMac([
                integratorReference,
                issuedToEcn,
                username
        ]);
        cancelVANRequest.setMessageDigest(messageDigest);
        CancelVANResponse cancelVANResponse = binding.cancelVAN(cancelVANRequest);


        String errCode = cancelVANResponse.getErrorCode();

        def retMap = [
                "errCode"           : errCode == "0" ? "00" : errCode,
                "errCodeDes"        : cancelVANResponse.getErrorDescription(),
                "vNettTransactionID": cancelVANResponse.getVNettTransactionID(),

        ];
        System.err.println("retMap:" + retMap);

        //retMap:["Successful":true, "errorCode":0, "ErrorDescription":null, "vNettTransactionID":1618239]
        return retMap
    }

    /*
    * 获取VAN详情
    *  getVANRequest
    * */

    @Service(dwr = true)
    def getVANDetails(String virtualAccountNumber) {


//        virtualAccountNumber = "5578955001387980"

        GetVANRequest getVANRequest = new GetVANRequest();
        getVANRequest.setIntegratorCode(integratorCode);
        getVANRequest.setIntegratorAccessKey(integratorAccessKey);
        getVANRequest.setRequesterEcn(requesterECN);


        String integratorReference = System.currentTimeMillis() + "";
        getVANRequest.setIntegratorReference(integratorReference);

        getVANRequest.setVirtualAccountNumber(virtualAccountNumber);
        getVANRequest.setUsername(username);


        String messageDigest = calcMac([
                requesterECN,
                integratorReference,
                virtualAccountNumber
        ]);
        getVANRequest.setMessageDigest(messageDigest);
        GetVANResponse getVANResponse = binding.getVANDetails(getVANRequest);

        String errCode = getVANResponse.getErrorCode();


        def retMap = [
                "errCode"           : errCode == "0" ? "00" : errCode,
                "errCodeDes"          : getVANResponse.getErrorDescription(),
                "supportLogID"              : getVANResponse.getSupportLogId(),
                "vNettTransactionID"        : getVANResponse.getVNettTransactionID(),
                "integratorReference"       : getVANResponse.getIntegratorReference(),
                "channel"                   : getVANResponse.getChannel(),
                "virtualAccountNumber"      : getVANResponse.getVirtualAccountNumber(),
                "expiryDate"                : getVANResponse.getCardExpiryDate(),
                "fullExpiryDate"            : getVANResponse.getFullExpiryDate(),
                "cardSecurityCode"          : getVANResponse.getCardSecurityCode(),
                "cardholderName"            : getVANResponse.getCardHolderName(),
                "activationDate"            : getVANResponse.getActivationDate(),
                "cardType"                  : getVANResponse.getCardType(),
                "country"                   : getVANResponse.getCountry(),
                "currency"                  : getVANResponse.getCurrency(),
                "fundedAmount"              : getVANResponse.getFundedAmount(),
                "isFunded"                  : getVANResponse.isIsFunded(),
                "fundingCurrencyCode"       : getVANResponse.getFundedCurrencyCode(),
                "fXRate"                    : getVANResponse.getFxRate(),
                "isMultiUse"                : getVANResponse.isIsMultiUse(),
                "multiUseClosePercentage"   : getVANResponse.getMultiClosePercentage(),
                "minimumAuthorisationAmount": getVANResponse.getMinimumAuthorisationAmount(),
                "maximumAuthorisationAmount": getVANResponse.getMaximumAuthorisationAmount(),
                "merchantCategoryCode"      : getVANResponse.getMerchantCategoryCode(),
                "merchantCategoryName"      : getVANResponse.getMerchantCategoryName(),
                "rCNAlias"                  : getVANResponse.getRcnAlias(),
                "rCNDescription"            : getVANResponse.getRCNDescription(),
                "totalAuthorisedAmount"     : getVANResponse.getTotalAuthorisedAmount(),
                "totalRefundedAmount"       : getVANResponse.getTotalRefundedAmount(),
                "totalSettledAmount"        : getVANResponse.getTotalSettledAmount(),
                "netSettledAmount"          : getVANResponse.getNetSettledAmount(),
                "outstandingAuthorisations" : getVANResponse.getOutstandingAuthorisations(),
                "availableBalance"          : getVANResponse.getAvailableBalance(),
                "fXFee"                     : getVANResponse.getFxFee(),
                "userReferences"            : getVANResponse.getUserReferences(),
                "notes"                     : getVANResponse.getNotes(),
                "vANHistoryCollection"      : getVANResponse.getVanHistoryCollection(),
                "fXHistoryCollection"       : getVANResponse.getFxHistoryCollection(),
        ];
        System.out.println("retMap:" + retMap);
        VanHistory[] vanHistoryCollection = getVANResponse.getVanHistoryCollection();
        def retVan = [
                "dateTime"    : vanHistoryCollection[1].getDateTime(),
                "activityType": vanHistoryCollection[1].getActivityType(),
                "details"     : vanHistoryCollection[1].getDetails()
        ];
        System.out.println("retVan:" + retVan);
        return [
                "virtualAccountNumber"      : getVANResponse.getVirtualAccountNumber(),
                "expiryDate"                : getVANResponse.getCardExpiryDate(),
                "fullExpiryDate"            : getVANResponse.getFullExpiryDate(),
                "cardSecurityCode"          : getVANResponse.getCardSecurityCode(),
                "cardholderName"            : getVANResponse.getCardHolderName(),
                "activationDate"            : getVANResponse.getActivationDate(),
                "cardType"                  : getVANResponse.getCardType(),
                "country"                   : getVANResponse.getCountry(),
                "currency"                  : getVANResponse.getCurrency(),
                "fundedAmount"              : getVANResponse.getFundedAmount(),
                "isFunded"                  : getVANResponse.isIsFunded(),
                "fundingCurrencyCode"       : getVANResponse.getFundedCurrencyCode(),
                "fXRate"                    : getVANResponse.getFxRate(),
                "isMultiUse"                : getVANResponse.isIsMultiUse(),
                "multiUseClosePercentage"   : getVANResponse.getMultiClosePercentage(),
                "minimumAuthorisationAmount": getVANResponse.getMinimumAuthorisationAmount(),
                "maximumAuthorisationAmount": getVANResponse.getMaximumAuthorisationAmount(),
                "merchantCategoryCode"      : getVANResponse.getMerchantCategoryCode(),
                "merchantCategoryName"      : getVANResponse.getMerchantCategoryName(),
                "totalAuthorisedAmount"     : getVANResponse.getTotalAuthorisedAmount(),
                "totalRefundedAmount"       : getVANResponse.getTotalRefundedAmount(),
                "totalSettledAmount"        : getVANResponse.getTotalSettledAmount(),
                "netSettledAmount"          : getVANResponse.getNetSettledAmount(),
                "availableBalance"          : getVANResponse.getAvailableBalance()
        ];
        //retMap:["Successful":true, "errorCode":0, "ErrorDescription":null, "SupportLogID":null, "vNettTransactionID":1618239, "IntegratorReference":"1508814796744", "RequesterECN":500429, "IssuedToECN":500429, "Channel":null, "VirtualAccountNumber":"5578955001387980", "ExpiryDate":"11/2018", "FullExpiryDate":"20181111", "CardSecurityCode":"536", "CardholderName":"Easy Pay Demo", "ActivationDate":"20171111", "CardType":"MASTERCARD", "Country":"HK", "Currency":"HKD", "FundedAmount":0, "IsFunded":false, "FundingCurrencyCode":"HKD", "FXRate":0, "IsMultiUse":true, "MultiUseClosePercentage":95.000, "MinimumAuthorisationAmount":0, "MaximumAuthorisationAmount":100000, "MerchantCategoryCode":"", "MerchantCategoryName":"Airline", "RCNAlias":null, "RCNDescription":null, "TotalAuthorisedAmount":0, "TotalRefundedAmount":0, "TotalSettledAmount":0, "NetSettledAmount":0, "OutstandingAuthorisations":0, "AvailableBalance":0, "FXFee":0, "UserReferences":[com.enett.ws.client.UserReference@350e40f5, com.enett.ws.client.UserReference@350e40f6, com.enett.ws.client.UserReference@350e40f7, com.enett.ws.client.UserReference@350e40f8], "Notes":"Replacement VAN", "VANHistoryCollection":[com.enett.ws.client.VanHistory@99877251, com.enett.ws.client.VanHistory@b93cd7de], "FXHistoryCollection":[]]
    }


    private String calcMac(def strs) {
        String key = "Dn82Gmw3FSr1g7R5";
        StringBuilder builder = new StringBuilder();


        for (String str : strs) {
            System.err.println(str);
            builder.append(str);
        }

        String src = key + builder.toString();
        System.err.println(src);
        return Base64.encodeBase64String(DigestUtils.sha(src)).trim();


    }
}
