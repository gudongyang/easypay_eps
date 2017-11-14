package cn.test;

import com.enett.ws.client.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.rpc.ServiceException;

public class Test {
    private static Log log = LogFactory.getLog(Test.class);

    public static String accessKey = "Dn82Gmw3FSr1g7R5";//"y4M2HfTz5b0J9QpX";// "";


    static String integratorCode = "EASYPAYDEMO";
    static String integratorAccessKey = "djsp0Adijh1hGPBxk9F57zHu72qIP4LDZNkFVtK3TUgA8hD8MEBART1KVBL7DdfW";
    static int requesterECN = 500429;

    static int clientECN = 500429;//requesterECN;

    static String username = "TFALLA";

    private static BasicHttpBinding_IvNettServiceV2Stub binding;


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

    public static void main(String[] args) throws Throwable {

//        Security.setProperty("ssl.SocketFactory.provider", "cn.test.TLSSocketConnectionFactory");

//        Security.addProvider(new BouncyCastleProvider());


        System.setProperty("https.protocols", "TLSv1.2");


//        SSLEngine
//        SSLSocket.
//        test1();

        getFxQuote();
    }


    static public void getFxQuote() throws Throwable {

        // Test operation
        GetFxQuoteRequest request = new GetFxQuoteRequest();
        GetFxQuoteRequest quoteRequest = request;
        String buyCurrency = "USD";
        String selCurrency = "HKD";
        String messageDigest = calcMac(new String[]{clientECN + "", buyCurrency, selCurrency});
        quoteRequest.setIntegratorCode(integratorCode);
        quoteRequest.setIntegratorAccessKey(integratorAccessKey);
        quoteRequest.setRequesterECN(requesterECN);
        quoteRequest.setClientEcn(clientECN);

        quoteRequest.setBuyCurrency(buyCurrency);
        quoteRequest.setSellCurrency(selCurrency);

        quoteRequest.setMessageDigest(messageDigest);
        GetFxQuoteResponse value = binding.getFxQuote(request);
        System.err.println("errorCode:"+value.getErrorCode());


    }


    static public void issueVAN() throws Throwable {
        IssueVANRequest issueVANRequest = new IssueVANRequest();
        issueVANRequest.setIntegratorCode(Test.integratorCode);
        issueVANRequest.setIntegratorAccessKey(Test.integratorAccessKey);
        issueVANRequest.setRequesterEcn(Test.requesterECN);
        int issuedToEcn = Test.requesterECN;
        issueVANRequest.setIssuedToEcn(issuedToEcn);

        issueVANRequest.setUsername(Test.username);

        String integratorReference = System.currentTimeMillis() + "";
        issueVANRequest.setIntegratorReference(integratorReference);

        issueVANRequest.setCountryCode("HK");//
        String currencyCode = "HKD";

        issueVANRequest.setCurrencyCode(currencyCode);

        String cardTypeName = "MASTERCARD";
        issueVANRequest.setCardTypeName(cardTypeName);

        int minimumAuthorisationAmount = 0; //IsMultiUse 为true时固定是0
        issueVANRequest.setMinimumAuthorisationAmount(minimumAuthorisationAmount);
        int maximumAuthorisationAmount = 100000;
        issueVANRequest.setMaximumAuthorisationAmount(maximumAuthorisationAmount);

        String activationDate = "20171111";
        issueVANRequest.setActivationDate(activationDate);
        issueVANRequest.setExpiryDate("20181111");
        issueVANRequest.setIsInstantAuthRequired(false);

        issueVANRequest.setIsMultiUse(true);
        issueVANRequest.setMultiUseClosePercentage(95);
        String merchantCategoryName = "AIRLINE";
        issueVANRequest.setMerchantCategoryName(merchantCategoryName);
        issueVANRequest.setFundingCurrencyCode(currencyCode);
        String notes = "Replacement VAN";
        issueVANRequest.setNotes(notes);


        String messageDigest = calcMac(new String[]{
                integratorReference ,
                activationDate,
                cardTypeName,
                currencyCode,
                issuedToEcn + "",
                maximumAuthorisationAmount + "",
                minimumAuthorisationAmount + "",
                merchantCategoryName,
                notes,
                username
        });
        issueVANRequest.setMessageDigest(messageDigest);
        IssueVANResponse issueVANResponse = binding.issueVAN(issueVANRequest);
        System.err.println("errorCode:"+issueVANResponse.getErrorCode());

    }


    public static void cancelVAN() {
        int issuedToEcn = requesterECN;
        String reference = "12";//交易流水
        CancelVANRequest cancelVANRequest = new CancelVANRequest();
        cancelVANRequest.setIntegratorCode(integratorCode);
        cancelVANRequest.setIntegratorAccessKey(integratorAccessKey);
        cancelVANRequest.setIssuedToEcn(issuedToEcn);
        cancelVANRequest.setRequesterEcn(requesterECN);
        cancelVANRequest.setIntegratorReference(reference);
        cancelVANRequest.setUsername(username);
        cancelVANRequest.setCancelReason(CancelReasonType.ErrorInOriginalRequest);

        String sourceStr = reference + issuedToEcn + username;


    }


    private static String calcMac(String[] strs) {
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
