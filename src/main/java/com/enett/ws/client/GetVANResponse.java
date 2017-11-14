/**
 * GetVANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class GetVANResponse  implements java.io.Serializable {
    private Boolean isSuccessful;

    private Integer errorCode;

    private String errorDescription;

    private String supportLogId;

    private String activationDate;

    private String cardHolderName;

    private String cardSecurityCode;

    private String cardType;

    private String country;

    private String currency;

    private String fullExpiryDate;

    private String integratorReference;

    private boolean isMultiUse;

    private int issuedToECN;

    private long maximumAuthorisationAmount;

    private String merchantCategoryCode;

    private String merchantCategoryName;

    private long minimumAuthorisationAmount;

    private String notes;

    private int requesterECN;

    private long totalAuthorisedAmount;

    private long totalRefundedAmount;

    private long totalSettledAmount;

    private int VNettTransactionID;

    private VanHistory[] vanHistoryCollection;

    private String virtualAccountNumber;

    private java.math.BigDecimal multiClosePercentage;

    private boolean isFunded;

    private String fundedCurrencyCode;

    private java.math.BigDecimal fxRate;

    private long fundedAmount;

    private FxHistory[] fxHistoryCollection;

    private java.math.BigDecimal availableBalance;

    private UserReference[] userReferences;

    private java.math.BigDecimal netSettledAmount;

    private java.math.BigDecimal outstandingAuthorisations;

    private String rcnAlias;

    private String RCNDescription;

    private java.math.BigDecimal fxFee;

    private String cardExpiryDate;

    private java.math.BigDecimal safetyMargin;

    private String channel;

    public GetVANResponse() {
    }

    public GetVANResponse(
           Boolean isSuccessful,
           Integer errorCode,
           String errorDescription,
           String supportLogId,
           String activationDate,
           String cardHolderName,
           String cardSecurityCode,
           String cardType,
           String country,
           String currency,
           String fullExpiryDate,
           String integratorReference,
           boolean isMultiUse,
           int issuedToECN,
           long maximumAuthorisationAmount,
           String merchantCategoryCode,
           String merchantCategoryName,
           long minimumAuthorisationAmount,
           String notes,
           int requesterECN,
           long totalAuthorisedAmount,
           long totalRefundedAmount,
           long totalSettledAmount,
           int VNettTransactionID,
           VanHistory[] vanHistoryCollection,
           String virtualAccountNumber,
           java.math.BigDecimal multiClosePercentage,
           boolean isFunded,
           String fundedCurrencyCode,
           java.math.BigDecimal fxRate,
           long fundedAmount,
           FxHistory[] fxHistoryCollection,
           java.math.BigDecimal availableBalance,
           UserReference[] userReferences,
           java.math.BigDecimal netSettledAmount,
           java.math.BigDecimal outstandingAuthorisations,
           String rcnAlias,
           String RCNDescription,
           java.math.BigDecimal fxFee,
           String cardExpiryDate,
           java.math.BigDecimal safetyMargin,
           String channel) {
           this.isSuccessful = isSuccessful;
           this.errorCode = errorCode;
           this.errorDescription = errorDescription;
           this.supportLogId = supportLogId;
           this.activationDate = activationDate;
           this.cardHolderName = cardHolderName;
           this.cardSecurityCode = cardSecurityCode;
           this.cardType = cardType;
           this.country = country;
           this.currency = currency;
           this.fullExpiryDate = fullExpiryDate;
           this.integratorReference = integratorReference;
           this.isMultiUse = isMultiUse;
           this.issuedToECN = issuedToECN;
           this.maximumAuthorisationAmount = maximumAuthorisationAmount;
           this.merchantCategoryCode = merchantCategoryCode;
           this.merchantCategoryName = merchantCategoryName;
           this.minimumAuthorisationAmount = minimumAuthorisationAmount;
           this.notes = notes;
           this.requesterECN = requesterECN;
           this.totalAuthorisedAmount = totalAuthorisedAmount;
           this.totalRefundedAmount = totalRefundedAmount;
           this.totalSettledAmount = totalSettledAmount;
           this.VNettTransactionID = VNettTransactionID;
           this.vanHistoryCollection = vanHistoryCollection;
           this.virtualAccountNumber = virtualAccountNumber;
           this.multiClosePercentage = multiClosePercentage;
           this.isFunded = isFunded;
           this.fundedCurrencyCode = fundedCurrencyCode;
           this.fxRate = fxRate;
           this.fundedAmount = fundedAmount;
           this.fxHistoryCollection = fxHistoryCollection;
           this.availableBalance = availableBalance;
           this.userReferences = userReferences;
           this.netSettledAmount = netSettledAmount;
           this.outstandingAuthorisations = outstandingAuthorisations;
           this.rcnAlias = rcnAlias;
           this.RCNDescription = RCNDescription;
           this.fxFee = fxFee;
           this.cardExpiryDate = cardExpiryDate;
           this.safetyMargin = safetyMargin;
           this.channel = channel;
    }


    /**
     * Gets the isSuccessful value for this GetVANResponse.
     * 
     * @return isSuccessful
     */
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }


    /**
     * Sets the isSuccessful value for this GetVANResponse.
     * 
     * @param isSuccessful
     */
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }


    /**
     * Gets the errorCode value for this GetVANResponse.
     * 
     * @return errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this GetVANResponse.
     * 
     * @param errorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDescription value for this GetVANResponse.
     * 
     * @return errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this GetVANResponse.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the supportLogId value for this GetVANResponse.
     * 
     * @return supportLogId
     */
    public String getSupportLogId() {
        return supportLogId;
    }


    /**
     * Sets the supportLogId value for this GetVANResponse.
     * 
     * @param supportLogId
     */
    public void setSupportLogId(String supportLogId) {
        this.supportLogId = supportLogId;
    }


    /**
     * Gets the activationDate value for this GetVANResponse.
     * 
     * @return activationDate
     */
    public String getActivationDate() {
        return activationDate;
    }


    /**
     * Sets the activationDate value for this GetVANResponse.
     * 
     * @param activationDate
     */
    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }


    /**
     * Gets the cardHolderName value for this GetVANResponse.
     * 
     * @return cardHolderName
     */
    public String getCardHolderName() {
        return cardHolderName;
    }


    /**
     * Sets the cardHolderName value for this GetVANResponse.
     * 
     * @param cardHolderName
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }


    /**
     * Gets the cardSecurityCode value for this GetVANResponse.
     * 
     * @return cardSecurityCode
     */
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }


    /**
     * Sets the cardSecurityCode value for this GetVANResponse.
     * 
     * @param cardSecurityCode
     */
    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }


    /**
     * Gets the cardType value for this GetVANResponse.
     * 
     * @return cardType
     */
    public String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this GetVANResponse.
     * 
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the country value for this GetVANResponse.
     * 
     * @return country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this GetVANResponse.
     * 
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * Gets the currency value for this GetVANResponse.
     * 
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this GetVANResponse.
     * 
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }


    /**
     * Gets the fullExpiryDate value for this GetVANResponse.
     * 
     * @return fullExpiryDate
     */
    public String getFullExpiryDate() {
        return fullExpiryDate;
    }


    /**
     * Sets the fullExpiryDate value for this GetVANResponse.
     * 
     * @param fullExpiryDate
     */
    public void setFullExpiryDate(String fullExpiryDate) {
        this.fullExpiryDate = fullExpiryDate;
    }


    /**
     * Gets the integratorReference value for this GetVANResponse.
     * 
     * @return integratorReference
     */
    public String getIntegratorReference() {
        return integratorReference;
    }


    /**
     * Sets the integratorReference value for this GetVANResponse.
     * 
     * @param integratorReference
     */
    public void setIntegratorReference(String integratorReference) {
        this.integratorReference = integratorReference;
    }


    /**
     * Gets the isMultiUse value for this GetVANResponse.
     * 
     * @return isMultiUse
     */
    public boolean isIsMultiUse() {
        return isMultiUse;
    }


    /**
     * Sets the isMultiUse value for this GetVANResponse.
     * 
     * @param isMultiUse
     */
    public void setIsMultiUse(boolean isMultiUse) {
        this.isMultiUse = isMultiUse;
    }


    /**
     * Gets the issuedToECN value for this GetVANResponse.
     * 
     * @return issuedToECN
     */
    public int getIssuedToECN() {
        return issuedToECN;
    }


    /**
     * Sets the issuedToECN value for this GetVANResponse.
     * 
     * @param issuedToECN
     */
    public void setIssuedToECN(int issuedToECN) {
        this.issuedToECN = issuedToECN;
    }


    /**
     * Gets the maximumAuthorisationAmount value for this GetVANResponse.
     * 
     * @return maximumAuthorisationAmount
     */
    public long getMaximumAuthorisationAmount() {
        return maximumAuthorisationAmount;
    }


    /**
     * Sets the maximumAuthorisationAmount value for this GetVANResponse.
     * 
     * @param maximumAuthorisationAmount
     */
    public void setMaximumAuthorisationAmount(long maximumAuthorisationAmount) {
        this.maximumAuthorisationAmount = maximumAuthorisationAmount;
    }


    /**
     * Gets the merchantCategoryCode value for this GetVANResponse.
     * 
     * @return merchantCategoryCode
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }


    /**
     * Sets the merchantCategoryCode value for this GetVANResponse.
     * 
     * @param merchantCategoryCode
     */
    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }


    /**
     * Gets the merchantCategoryName value for this GetVANResponse.
     * 
     * @return merchantCategoryName
     */
    public String getMerchantCategoryName() {
        return merchantCategoryName;
    }


    /**
     * Sets the merchantCategoryName value for this GetVANResponse.
     * 
     * @param merchantCategoryName
     */
    public void setMerchantCategoryName(String merchantCategoryName) {
        this.merchantCategoryName = merchantCategoryName;
    }


    /**
     * Gets the minimumAuthorisationAmount value for this GetVANResponse.
     * 
     * @return minimumAuthorisationAmount
     */
    public long getMinimumAuthorisationAmount() {
        return minimumAuthorisationAmount;
    }


    /**
     * Sets the minimumAuthorisationAmount value for this GetVANResponse.
     * 
     * @param minimumAuthorisationAmount
     */
    public void setMinimumAuthorisationAmount(long minimumAuthorisationAmount) {
        this.minimumAuthorisationAmount = minimumAuthorisationAmount;
    }


    /**
     * Gets the notes value for this GetVANResponse.
     * 
     * @return notes
     */
    public String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this GetVANResponse.
     * 
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }


    /**
     * Gets the requesterECN value for this GetVANResponse.
     * 
     * @return requesterECN
     */
    public int getRequesterECN() {
        return requesterECN;
    }


    /**
     * Sets the requesterECN value for this GetVANResponse.
     * 
     * @param requesterECN
     */
    public void setRequesterECN(int requesterECN) {
        this.requesterECN = requesterECN;
    }


    /**
     * Gets the totalAuthorisedAmount value for this GetVANResponse.
     * 
     * @return totalAuthorisedAmount
     */
    public long getTotalAuthorisedAmount() {
        return totalAuthorisedAmount;
    }


    /**
     * Sets the totalAuthorisedAmount value for this GetVANResponse.
     * 
     * @param totalAuthorisedAmount
     */
    public void setTotalAuthorisedAmount(long totalAuthorisedAmount) {
        this.totalAuthorisedAmount = totalAuthorisedAmount;
    }


    /**
     * Gets the totalRefundedAmount value for this GetVANResponse.
     * 
     * @return totalRefundedAmount
     */
    public long getTotalRefundedAmount() {
        return totalRefundedAmount;
    }


    /**
     * Sets the totalRefundedAmount value for this GetVANResponse.
     * 
     * @param totalRefundedAmount
     */
    public void setTotalRefundedAmount(long totalRefundedAmount) {
        this.totalRefundedAmount = totalRefundedAmount;
    }


    /**
     * Gets the totalSettledAmount value for this GetVANResponse.
     * 
     * @return totalSettledAmount
     */
    public long getTotalSettledAmount() {
        return totalSettledAmount;
    }


    /**
     * Sets the totalSettledAmount value for this GetVANResponse.
     * 
     * @param totalSettledAmount
     */
    public void setTotalSettledAmount(long totalSettledAmount) {
        this.totalSettledAmount = totalSettledAmount;
    }


    /**
     * Gets the VNettTransactionID value for this GetVANResponse.
     * 
     * @return VNettTransactionID
     */
    public int getVNettTransactionID() {
        return VNettTransactionID;
    }


    /**
     * Sets the VNettTransactionID value for this GetVANResponse.
     * 
     * @param VNettTransactionID
     */
    public void setVNettTransactionID(int VNettTransactionID) {
        this.VNettTransactionID = VNettTransactionID;
    }


    /**
     * Gets the vanHistoryCollection value for this GetVANResponse.
     * 
     * @return vanHistoryCollection
     */
    public VanHistory[] getVanHistoryCollection() {
        return vanHistoryCollection;
    }


    /**
     * Sets the vanHistoryCollection value for this GetVANResponse.
     * 
     * @param vanHistoryCollection
     */
    public void setVanHistoryCollection(VanHistory[] vanHistoryCollection) {
        this.vanHistoryCollection = vanHistoryCollection;
    }


    /**
     * Gets the virtualAccountNumber value for this GetVANResponse.
     * 
     * @return virtualAccountNumber
     */
    public String getVirtualAccountNumber() {
        return virtualAccountNumber;
    }


    /**
     * Sets the virtualAccountNumber value for this GetVANResponse.
     * 
     * @param virtualAccountNumber
     */
    public void setVirtualAccountNumber(String virtualAccountNumber) {
        this.virtualAccountNumber = virtualAccountNumber;
    }


    /**
     * Gets the multiClosePercentage value for this GetVANResponse.
     * 
     * @return multiClosePercentage
     */
    public java.math.BigDecimal getMultiClosePercentage() {
        return multiClosePercentage;
    }


    /**
     * Sets the multiClosePercentage value for this GetVANResponse.
     * 
     * @param multiClosePercentage
     */
    public void setMultiClosePercentage(java.math.BigDecimal multiClosePercentage) {
        this.multiClosePercentage = multiClosePercentage;
    }


    /**
     * Gets the isFunded value for this GetVANResponse.
     * 
     * @return isFunded
     */
    public boolean isIsFunded() {
        return isFunded;
    }


    /**
     * Sets the isFunded value for this GetVANResponse.
     * 
     * @param isFunded
     */
    public void setIsFunded(boolean isFunded) {
        this.isFunded = isFunded;
    }


    /**
     * Gets the fundedCurrencyCode value for this GetVANResponse.
     * 
     * @return fundedCurrencyCode
     */
    public String getFundedCurrencyCode() {
        return fundedCurrencyCode;
    }


    /**
     * Sets the fundedCurrencyCode value for this GetVANResponse.
     * 
     * @param fundedCurrencyCode
     */
    public void setFundedCurrencyCode(String fundedCurrencyCode) {
        this.fundedCurrencyCode = fundedCurrencyCode;
    }


    /**
     * Gets the fxRate value for this GetVANResponse.
     * 
     * @return fxRate
     */
    public java.math.BigDecimal getFxRate() {
        return fxRate;
    }


    /**
     * Sets the fxRate value for this GetVANResponse.
     * 
     * @param fxRate
     */
    public void setFxRate(java.math.BigDecimal fxRate) {
        this.fxRate = fxRate;
    }


    /**
     * Gets the fundedAmount value for this GetVANResponse.
     * 
     * @return fundedAmount
     */
    public long getFundedAmount() {
        return fundedAmount;
    }


    /**
     * Sets the fundedAmount value for this GetVANResponse.
     * 
     * @param fundedAmount
     */
    public void setFundedAmount(long fundedAmount) {
        this.fundedAmount = fundedAmount;
    }


    /**
     * Gets the fxHistoryCollection value for this GetVANResponse.
     * 
     * @return fxHistoryCollection
     */
    public FxHistory[] getFxHistoryCollection() {
        return fxHistoryCollection;
    }


    /**
     * Sets the fxHistoryCollection value for this GetVANResponse.
     * 
     * @param fxHistoryCollection
     */
    public void setFxHistoryCollection(FxHistory[] fxHistoryCollection) {
        this.fxHistoryCollection = fxHistoryCollection;
    }


    /**
     * Gets the availableBalance value for this GetVANResponse.
     * 
     * @return availableBalance
     */
    public java.math.BigDecimal getAvailableBalance() {
        return availableBalance;
    }


    /**
     * Sets the availableBalance value for this GetVANResponse.
     * 
     * @param availableBalance
     */
    public void setAvailableBalance(java.math.BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }


    /**
     * Gets the userReferences value for this GetVANResponse.
     * 
     * @return userReferences
     */
    public UserReference[] getUserReferences() {
        return userReferences;
    }


    /**
     * Sets the userReferences value for this GetVANResponse.
     * 
     * @param userReferences
     */
    public void setUserReferences(UserReference[] userReferences) {
        this.userReferences = userReferences;
    }


    /**
     * Gets the netSettledAmount value for this GetVANResponse.
     * 
     * @return netSettledAmount
     */
    public java.math.BigDecimal getNetSettledAmount() {
        return netSettledAmount;
    }


    /**
     * Sets the netSettledAmount value for this GetVANResponse.
     * 
     * @param netSettledAmount
     */
    public void setNetSettledAmount(java.math.BigDecimal netSettledAmount) {
        this.netSettledAmount = netSettledAmount;
    }


    /**
     * Gets the outstandingAuthorisations value for this GetVANResponse.
     * 
     * @return outstandingAuthorisations
     */
    public java.math.BigDecimal getOutstandingAuthorisations() {
        return outstandingAuthorisations;
    }


    /**
     * Sets the outstandingAuthorisations value for this GetVANResponse.
     * 
     * @param outstandingAuthorisations
     */
    public void setOutstandingAuthorisations(java.math.BigDecimal outstandingAuthorisations) {
        this.outstandingAuthorisations = outstandingAuthorisations;
    }


    /**
     * Gets the rcnAlias value for this GetVANResponse.
     * 
     * @return rcnAlias
     */
    public String getRcnAlias() {
        return rcnAlias;
    }


    /**
     * Sets the rcnAlias value for this GetVANResponse.
     * 
     * @param rcnAlias
     */
    public void setRcnAlias(String rcnAlias) {
        this.rcnAlias = rcnAlias;
    }


    /**
     * Gets the RCNDescription value for this GetVANResponse.
     * 
     * @return RCNDescription
     */
    public String getRCNDescription() {
        return RCNDescription;
    }


    /**
     * Sets the RCNDescription value for this GetVANResponse.
     * 
     * @param RCNDescription
     */
    public void setRCNDescription(String RCNDescription) {
        this.RCNDescription = RCNDescription;
    }


    /**
     * Gets the fxFee value for this GetVANResponse.
     * 
     * @return fxFee
     */
    public java.math.BigDecimal getFxFee() {
        return fxFee;
    }


    /**
     * Sets the fxFee value for this GetVANResponse.
     * 
     * @param fxFee
     */
    public void setFxFee(java.math.BigDecimal fxFee) {
        this.fxFee = fxFee;
    }


    /**
     * Gets the cardExpiryDate value for this GetVANResponse.
     * 
     * @return cardExpiryDate
     */
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }


    /**
     * Sets the cardExpiryDate value for this GetVANResponse.
     * 
     * @param cardExpiryDate
     */
    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }


    /**
     * Gets the safetyMargin value for this GetVANResponse.
     * 
     * @return safetyMargin
     */
    public java.math.BigDecimal getSafetyMargin() {
        return safetyMargin;
    }


    /**
     * Sets the safetyMargin value for this GetVANResponse.
     * 
     * @param safetyMargin
     */
    public void setSafetyMargin(java.math.BigDecimal safetyMargin) {
        this.safetyMargin = safetyMargin;
    }


    /**
     * Gets the channel value for this GetVANResponse.
     * 
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this GetVANResponse.
     * 
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetVANResponse)) return false;
        GetVANResponse other = (GetVANResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.isSuccessful==null && other.getIsSuccessful()==null) || 
             (this.isSuccessful!=null &&
              this.isSuccessful.equals(other.getIsSuccessful()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.supportLogId==null && other.getSupportLogId()==null) || 
             (this.supportLogId!=null &&
              this.supportLogId.equals(other.getSupportLogId()))) &&
            ((this.activationDate==null && other.getActivationDate()==null) || 
             (this.activationDate!=null &&
              this.activationDate.equals(other.getActivationDate()))) &&
            ((this.cardHolderName==null && other.getCardHolderName()==null) || 
             (this.cardHolderName!=null &&
              this.cardHolderName.equals(other.getCardHolderName()))) &&
            ((this.cardSecurityCode==null && other.getCardSecurityCode()==null) || 
             (this.cardSecurityCode!=null &&
              this.cardSecurityCode.equals(other.getCardSecurityCode()))) &&
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.fullExpiryDate==null && other.getFullExpiryDate()==null) || 
             (this.fullExpiryDate!=null &&
              this.fullExpiryDate.equals(other.getFullExpiryDate()))) &&
            ((this.integratorReference==null && other.getIntegratorReference()==null) || 
             (this.integratorReference!=null &&
              this.integratorReference.equals(other.getIntegratorReference()))) &&
            this.isMultiUse == other.isIsMultiUse() &&
            this.issuedToECN == other.getIssuedToECN() &&
            this.maximumAuthorisationAmount == other.getMaximumAuthorisationAmount() &&
            ((this.merchantCategoryCode==null && other.getMerchantCategoryCode()==null) || 
             (this.merchantCategoryCode!=null &&
              this.merchantCategoryCode.equals(other.getMerchantCategoryCode()))) &&
            ((this.merchantCategoryName==null && other.getMerchantCategoryName()==null) || 
             (this.merchantCategoryName!=null &&
              this.merchantCategoryName.equals(other.getMerchantCategoryName()))) &&
            this.minimumAuthorisationAmount == other.getMinimumAuthorisationAmount() &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            this.requesterECN == other.getRequesterECN() &&
            this.totalAuthorisedAmount == other.getTotalAuthorisedAmount() &&
            this.totalRefundedAmount == other.getTotalRefundedAmount() &&
            this.totalSettledAmount == other.getTotalSettledAmount() &&
            this.VNettTransactionID == other.getVNettTransactionID() &&
            ((this.vanHistoryCollection==null && other.getVanHistoryCollection()==null) || 
             (this.vanHistoryCollection!=null &&
              java.util.Arrays.equals(this.vanHistoryCollection, other.getVanHistoryCollection()))) &&
            ((this.virtualAccountNumber==null && other.getVirtualAccountNumber()==null) || 
             (this.virtualAccountNumber!=null &&
              this.virtualAccountNumber.equals(other.getVirtualAccountNumber()))) &&
            ((this.multiClosePercentage==null && other.getMultiClosePercentage()==null) || 
             (this.multiClosePercentage!=null &&
              this.multiClosePercentage.equals(other.getMultiClosePercentage()))) &&
            this.isFunded == other.isIsFunded() &&
            ((this.fundedCurrencyCode==null && other.getFundedCurrencyCode()==null) || 
             (this.fundedCurrencyCode!=null &&
              this.fundedCurrencyCode.equals(other.getFundedCurrencyCode()))) &&
            ((this.fxRate==null && other.getFxRate()==null) || 
             (this.fxRate!=null &&
              this.fxRate.equals(other.getFxRate()))) &&
            this.fundedAmount == other.getFundedAmount() &&
            ((this.fxHistoryCollection==null && other.getFxHistoryCollection()==null) || 
             (this.fxHistoryCollection!=null &&
              java.util.Arrays.equals(this.fxHistoryCollection, other.getFxHistoryCollection()))) &&
            ((this.availableBalance==null && other.getAvailableBalance()==null) || 
             (this.availableBalance!=null &&
              this.availableBalance.equals(other.getAvailableBalance()))) &&
            ((this.userReferences==null && other.getUserReferences()==null) || 
             (this.userReferences!=null &&
              java.util.Arrays.equals(this.userReferences, other.getUserReferences()))) &&
            ((this.netSettledAmount==null && other.getNetSettledAmount()==null) || 
             (this.netSettledAmount!=null &&
              this.netSettledAmount.equals(other.getNetSettledAmount()))) &&
            ((this.outstandingAuthorisations==null && other.getOutstandingAuthorisations()==null) || 
             (this.outstandingAuthorisations!=null &&
              this.outstandingAuthorisations.equals(other.getOutstandingAuthorisations()))) &&
            ((this.rcnAlias==null && other.getRcnAlias()==null) || 
             (this.rcnAlias!=null &&
              this.rcnAlias.equals(other.getRcnAlias()))) &&
            ((this.RCNDescription==null && other.getRCNDescription()==null) || 
             (this.RCNDescription!=null &&
              this.RCNDescription.equals(other.getRCNDescription()))) &&
            ((this.fxFee==null && other.getFxFee()==null) || 
             (this.fxFee!=null &&
              this.fxFee.equals(other.getFxFee()))) &&
            ((this.cardExpiryDate==null && other.getCardExpiryDate()==null) || 
             (this.cardExpiryDate!=null &&
              this.cardExpiryDate.equals(other.getCardExpiryDate()))) &&
            ((this.safetyMargin==null && other.getSafetyMargin()==null) || 
             (this.safetyMargin!=null &&
              this.safetyMargin.equals(other.getSafetyMargin()))) &&
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIsSuccessful() != null) {
            _hashCode += getIsSuccessful().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getSupportLogId() != null) {
            _hashCode += getSupportLogId().hashCode();
        }
        if (getActivationDate() != null) {
            _hashCode += getActivationDate().hashCode();
        }
        if (getCardHolderName() != null) {
            _hashCode += getCardHolderName().hashCode();
        }
        if (getCardSecurityCode() != null) {
            _hashCode += getCardSecurityCode().hashCode();
        }
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getFullExpiryDate() != null) {
            _hashCode += getFullExpiryDate().hashCode();
        }
        if (getIntegratorReference() != null) {
            _hashCode += getIntegratorReference().hashCode();
        }
        _hashCode += (isIsMultiUse() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getIssuedToECN();
        _hashCode += new Long(getMaximumAuthorisationAmount()).hashCode();
        if (getMerchantCategoryCode() != null) {
            _hashCode += getMerchantCategoryCode().hashCode();
        }
        if (getMerchantCategoryName() != null) {
            _hashCode += getMerchantCategoryName().hashCode();
        }
        _hashCode += new Long(getMinimumAuthorisationAmount()).hashCode();
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        _hashCode += getRequesterECN();
        _hashCode += new Long(getTotalAuthorisedAmount()).hashCode();
        _hashCode += new Long(getTotalRefundedAmount()).hashCode();
        _hashCode += new Long(getTotalSettledAmount()).hashCode();
        _hashCode += getVNettTransactionID();
        if (getVanHistoryCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVanHistoryCollection());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getVanHistoryCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVirtualAccountNumber() != null) {
            _hashCode += getVirtualAccountNumber().hashCode();
        }
        if (getMultiClosePercentage() != null) {
            _hashCode += getMultiClosePercentage().hashCode();
        }
        _hashCode += (isIsFunded() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFundedCurrencyCode() != null) {
            _hashCode += getFundedCurrencyCode().hashCode();
        }
        if (getFxRate() != null) {
            _hashCode += getFxRate().hashCode();
        }
        _hashCode += new Long(getFundedAmount()).hashCode();
        if (getFxHistoryCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFxHistoryCollection());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getFxHistoryCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAvailableBalance() != null) {
            _hashCode += getAvailableBalance().hashCode();
        }
        if (getUserReferences() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserReferences());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getUserReferences(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNetSettledAmount() != null) {
            _hashCode += getNetSettledAmount().hashCode();
        }
        if (getOutstandingAuthorisations() != null) {
            _hashCode += getOutstandingAuthorisations().hashCode();
        }
        if (getRcnAlias() != null) {
            _hashCode += getRcnAlias().hashCode();
        }
        if (getRCNDescription() != null) {
            _hashCode += getRCNDescription().hashCode();
        }
        if (getFxFee() != null) {
            _hashCode += getFxFee().hashCode();
        }
        if (getCardExpiryDate() != null) {
            _hashCode += getCardExpiryDate().hashCode();
        }
        if (getSafetyMargin() != null) {
            _hashCode += getSafetyMargin().hashCode();
        }
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetVANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetVANResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSuccessful");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IsSuccessful"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ErrorDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportLogId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SupportLogId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ActivationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardSecurityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardSecurityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullExpiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FullExpiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integratorReference");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IntegratorReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMultiUse");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IsMultiUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuedToECN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssuedToECN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximumAuthorisationAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MaximumAuthorisationAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantCategoryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MerchantCategoryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantCategoryName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MerchantCategoryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimumAuthorisationAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MinimumAuthorisationAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterECN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RequesterECN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalAuthorisedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "TotalAuthorisedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRefundedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "TotalRefundedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSettledAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "TotalSettledAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VNettTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VNettTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vanHistoryCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VanHistoryCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VanHistory"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "VanHistory"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("virtualAccountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VirtualAccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multiClosePercentage");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MultiClosePercentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFunded");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IsFunded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundedCurrencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FundedCurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fxRate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FundedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fxHistoryCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxHistoryCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxHistory"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "FxHistory"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availableBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AvailableBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userReferences");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReferences"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netSettledAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "NetSettledAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outstandingAuthorisations");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "OutstandingAuthorisations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rcnAlias");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RcnAlias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RCNDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RCNDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fxFee");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardExpiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardExpiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("safetyMargin");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SafetyMargin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
