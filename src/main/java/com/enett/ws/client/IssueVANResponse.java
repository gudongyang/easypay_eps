/**
 * IssueVANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class IssueVANResponse  implements java.io.Serializable {
    private Boolean isSuccessful;

    private Integer errorCode;

    private String errorDescription;

    private String supportLogId;

    private String activationDate;

    private String cardHolderName;

    private String cardSecurityCode;

    private String expiryDate;

    private String fullExpiryDate;

    private String generationDate;

    private Integer VNettTransactionID;

    private String virtualAccountNumber;

    private long minimumAuthorisationAmount;

    private long maximumAuthorisationAmount;

    private Long fundedAmount;

    private String currencyCode;

    private String fundingCurrencyCode;

    private java.math.BigDecimal fxRate;

    private String RCNAlias;

    private String RCNDescription;

    private java.math.BigDecimal safetyMargin;

    private Integer accountId;

    public IssueVANResponse() {
    }

    public IssueVANResponse(
           Boolean isSuccessful,
           Integer errorCode,
           String errorDescription,
           String supportLogId,
           String activationDate,
           String cardHolderName,
           String cardSecurityCode,
           String expiryDate,
           String fullExpiryDate,
           String generationDate,
           Integer VNettTransactionID,
           String virtualAccountNumber,
           long minimumAuthorisationAmount,
           long maximumAuthorisationAmount,
           Long fundedAmount,
           String currencyCode,
           String fundingCurrencyCode,
           java.math.BigDecimal fxRate,
           String RCNAlias,
           String RCNDescription,
           java.math.BigDecimal safetyMargin,
           Integer accountId) {
           this.isSuccessful = isSuccessful;
           this.errorCode = errorCode;
           this.errorDescription = errorDescription;
           this.supportLogId = supportLogId;
           this.activationDate = activationDate;
           this.cardHolderName = cardHolderName;
           this.cardSecurityCode = cardSecurityCode;
           this.expiryDate = expiryDate;
           this.fullExpiryDate = fullExpiryDate;
           this.generationDate = generationDate;
           this.VNettTransactionID = VNettTransactionID;
           this.virtualAccountNumber = virtualAccountNumber;
           this.minimumAuthorisationAmount = minimumAuthorisationAmount;
           this.maximumAuthorisationAmount = maximumAuthorisationAmount;
           this.fundedAmount = fundedAmount;
           this.currencyCode = currencyCode;
           this.fundingCurrencyCode = fundingCurrencyCode;
           this.fxRate = fxRate;
           this.RCNAlias = RCNAlias;
           this.RCNDescription = RCNDescription;
           this.safetyMargin = safetyMargin;
           this.accountId = accountId;
    }


    /**
     * Gets the isSuccessful value for this IssueVANResponse.
     * 
     * @return isSuccessful
     */
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }


    /**
     * Sets the isSuccessful value for this IssueVANResponse.
     * 
     * @param isSuccessful
     */
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }


    /**
     * Gets the errorCode value for this IssueVANResponse.
     * 
     * @return errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this IssueVANResponse.
     * 
     * @param errorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDescription value for this IssueVANResponse.
     * 
     * @return errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this IssueVANResponse.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the supportLogId value for this IssueVANResponse.
     * 
     * @return supportLogId
     */
    public String getSupportLogId() {
        return supportLogId;
    }


    /**
     * Sets the supportLogId value for this IssueVANResponse.
     * 
     * @param supportLogId
     */
    public void setSupportLogId(String supportLogId) {
        this.supportLogId = supportLogId;
    }


    /**
     * Gets the activationDate value for this IssueVANResponse.
     * 
     * @return activationDate
     */
    public String getActivationDate() {
        return activationDate;
    }


    /**
     * Sets the activationDate value for this IssueVANResponse.
     * 
     * @param activationDate
     */
    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }


    /**
     * Gets the cardHolderName value for this IssueVANResponse.
     * 
     * @return cardHolderName
     */
    public String getCardHolderName() {
        return cardHolderName;
    }


    /**
     * Sets the cardHolderName value for this IssueVANResponse.
     * 
     * @param cardHolderName
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }


    /**
     * Gets the cardSecurityCode value for this IssueVANResponse.
     * 
     * @return cardSecurityCode
     */
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }


    /**
     * Sets the cardSecurityCode value for this IssueVANResponse.
     * 
     * @param cardSecurityCode
     */
    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }


    /**
     * Gets the expiryDate value for this IssueVANResponse.
     * 
     * @return expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiryDate value for this IssueVANResponse.
     * 
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    /**
     * Gets the fullExpiryDate value for this IssueVANResponse.
     * 
     * @return fullExpiryDate
     */
    public String getFullExpiryDate() {
        return fullExpiryDate;
    }


    /**
     * Sets the fullExpiryDate value for this IssueVANResponse.
     * 
     * @param fullExpiryDate
     */
    public void setFullExpiryDate(String fullExpiryDate) {
        this.fullExpiryDate = fullExpiryDate;
    }


    /**
     * Gets the generationDate value for this IssueVANResponse.
     * 
     * @return generationDate
     */
    public String getGenerationDate() {
        return generationDate;
    }


    /**
     * Sets the generationDate value for this IssueVANResponse.
     * 
     * @param generationDate
     */
    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }


    /**
     * Gets the VNettTransactionID value for this IssueVANResponse.
     * 
     * @return VNettTransactionID
     */
    public Integer getVNettTransactionID() {
        return VNettTransactionID;
    }


    /**
     * Sets the VNettTransactionID value for this IssueVANResponse.
     * 
     * @param VNettTransactionID
     */
    public void setVNettTransactionID(Integer VNettTransactionID) {
        this.VNettTransactionID = VNettTransactionID;
    }


    /**
     * Gets the virtualAccountNumber value for this IssueVANResponse.
     * 
     * @return virtualAccountNumber
     */
    public String getVirtualAccountNumber() {
        return virtualAccountNumber;
    }


    /**
     * Sets the virtualAccountNumber value for this IssueVANResponse.
     * 
     * @param virtualAccountNumber
     */
    public void setVirtualAccountNumber(String virtualAccountNumber) {
        this.virtualAccountNumber = virtualAccountNumber;
    }


    /**
     * Gets the minimumAuthorisationAmount value for this IssueVANResponse.
     * 
     * @return minimumAuthorisationAmount
     */
    public long getMinimumAuthorisationAmount() {
        return minimumAuthorisationAmount;
    }


    /**
     * Sets the minimumAuthorisationAmount value for this IssueVANResponse.
     * 
     * @param minimumAuthorisationAmount
     */
    public void setMinimumAuthorisationAmount(long minimumAuthorisationAmount) {
        this.minimumAuthorisationAmount = minimumAuthorisationAmount;
    }


    /**
     * Gets the maximumAuthorisationAmount value for this IssueVANResponse.
     * 
     * @return maximumAuthorisationAmount
     */
    public long getMaximumAuthorisationAmount() {
        return maximumAuthorisationAmount;
    }


    /**
     * Sets the maximumAuthorisationAmount value for this IssueVANResponse.
     * 
     * @param maximumAuthorisationAmount
     */
    public void setMaximumAuthorisationAmount(long maximumAuthorisationAmount) {
        this.maximumAuthorisationAmount = maximumAuthorisationAmount;
    }


    /**
     * Gets the fundedAmount value for this IssueVANResponse.
     * 
     * @return fundedAmount
     */
    public Long getFundedAmount() {
        return fundedAmount;
    }


    /**
     * Sets the fundedAmount value for this IssueVANResponse.
     * 
     * @param fundedAmount
     */
    public void setFundedAmount(Long fundedAmount) {
        this.fundedAmount = fundedAmount;
    }


    /**
     * Gets the currencyCode value for this IssueVANResponse.
     * 
     * @return currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this IssueVANResponse.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the fundingCurrencyCode value for this IssueVANResponse.
     * 
     * @return fundingCurrencyCode
     */
    public String getFundingCurrencyCode() {
        return fundingCurrencyCode;
    }


    /**
     * Sets the fundingCurrencyCode value for this IssueVANResponse.
     * 
     * @param fundingCurrencyCode
     */
    public void setFundingCurrencyCode(String fundingCurrencyCode) {
        this.fundingCurrencyCode = fundingCurrencyCode;
    }


    /**
     * Gets the fxRate value for this IssueVANResponse.
     * 
     * @return fxRate
     */
    public java.math.BigDecimal getFxRate() {
        return fxRate;
    }


    /**
     * Sets the fxRate value for this IssueVANResponse.
     * 
     * @param fxRate
     */
    public void setFxRate(java.math.BigDecimal fxRate) {
        this.fxRate = fxRate;
    }


    /**
     * Gets the RCNAlias value for this IssueVANResponse.
     * 
     * @return RCNAlias
     */
    public String getRCNAlias() {
        return RCNAlias;
    }


    /**
     * Sets the RCNAlias value for this IssueVANResponse.
     * 
     * @param RCNAlias
     */
    public void setRCNAlias(String RCNAlias) {
        this.RCNAlias = RCNAlias;
    }


    /**
     * Gets the RCNDescription value for this IssueVANResponse.
     * 
     * @return RCNDescription
     */
    public String getRCNDescription() {
        return RCNDescription;
    }


    /**
     * Sets the RCNDescription value for this IssueVANResponse.
     * 
     * @param RCNDescription
     */
    public void setRCNDescription(String RCNDescription) {
        this.RCNDescription = RCNDescription;
    }


    /**
     * Gets the safetyMargin value for this IssueVANResponse.
     * 
     * @return safetyMargin
     */
    public java.math.BigDecimal getSafetyMargin() {
        return safetyMargin;
    }


    /**
     * Sets the safetyMargin value for this IssueVANResponse.
     * 
     * @param safetyMargin
     */
    public void setSafetyMargin(java.math.BigDecimal safetyMargin) {
        this.safetyMargin = safetyMargin;
    }


    /**
     * Gets the accountId value for this IssueVANResponse.
     * 
     * @return accountId
     */
    public Integer getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this IssueVANResponse.
     * 
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof IssueVANResponse)) return false;
        IssueVANResponse other = (IssueVANResponse) obj;
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
            ((this.expiryDate==null && other.getExpiryDate()==null) || 
             (this.expiryDate!=null &&
              this.expiryDate.equals(other.getExpiryDate()))) &&
            ((this.fullExpiryDate==null && other.getFullExpiryDate()==null) || 
             (this.fullExpiryDate!=null &&
              this.fullExpiryDate.equals(other.getFullExpiryDate()))) &&
            ((this.generationDate==null && other.getGenerationDate()==null) || 
             (this.generationDate!=null &&
              this.generationDate.equals(other.getGenerationDate()))) &&
            ((this.VNettTransactionID==null && other.getVNettTransactionID()==null) || 
             (this.VNettTransactionID!=null &&
              this.VNettTransactionID.equals(other.getVNettTransactionID()))) &&
            ((this.virtualAccountNumber==null && other.getVirtualAccountNumber()==null) || 
             (this.virtualAccountNumber!=null &&
              this.virtualAccountNumber.equals(other.getVirtualAccountNumber()))) &&
            this.minimumAuthorisationAmount == other.getMinimumAuthorisationAmount() &&
            this.maximumAuthorisationAmount == other.getMaximumAuthorisationAmount() &&
            ((this.fundedAmount==null && other.getFundedAmount()==null) || 
             (this.fundedAmount!=null &&
              this.fundedAmount.equals(other.getFundedAmount()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.fundingCurrencyCode==null && other.getFundingCurrencyCode()==null) || 
             (this.fundingCurrencyCode!=null &&
              this.fundingCurrencyCode.equals(other.getFundingCurrencyCode()))) &&
            ((this.fxRate==null && other.getFxRate()==null) || 
             (this.fxRate!=null &&
              this.fxRate.equals(other.getFxRate()))) &&
            ((this.RCNAlias==null && other.getRCNAlias()==null) || 
             (this.RCNAlias!=null &&
              this.RCNAlias.equals(other.getRCNAlias()))) &&
            ((this.RCNDescription==null && other.getRCNDescription()==null) || 
             (this.RCNDescription!=null &&
              this.RCNDescription.equals(other.getRCNDescription()))) &&
            ((this.safetyMargin==null && other.getSafetyMargin()==null) || 
             (this.safetyMargin!=null &&
              this.safetyMargin.equals(other.getSafetyMargin()))) &&
            ((this.accountId==null && other.getAccountId()==null) || 
             (this.accountId!=null &&
              this.accountId.equals(other.getAccountId())));
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
        if (getExpiryDate() != null) {
            _hashCode += getExpiryDate().hashCode();
        }
        if (getFullExpiryDate() != null) {
            _hashCode += getFullExpiryDate().hashCode();
        }
        if (getGenerationDate() != null) {
            _hashCode += getGenerationDate().hashCode();
        }
        if (getVNettTransactionID() != null) {
            _hashCode += getVNettTransactionID().hashCode();
        }
        if (getVirtualAccountNumber() != null) {
            _hashCode += getVirtualAccountNumber().hashCode();
        }
        _hashCode += new Long(getMinimumAuthorisationAmount()).hashCode();
        _hashCode += new Long(getMaximumAuthorisationAmount()).hashCode();
        if (getFundedAmount() != null) {
            _hashCode += getFundedAmount().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getFundingCurrencyCode() != null) {
            _hashCode += getFundingCurrencyCode().hashCode();
        }
        if (getFxRate() != null) {
            _hashCode += getFxRate().hashCode();
        }
        if (getRCNAlias() != null) {
            _hashCode += getRCNAlias().hashCode();
        }
        if (getRCNDescription() != null) {
            _hashCode += getRCNDescription().hashCode();
        }
        if (getSafetyMargin() != null) {
            _hashCode += getSafetyMargin().hashCode();
        }
        if (getAccountId() != null) {
            _hashCode += getAccountId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IssueVANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssueVANResponse"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardSecurityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardSecurityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ExpiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullExpiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FullExpiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GenerationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VNettTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VNettTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("virtualAccountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VirtualAccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimumAuthorisationAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MinimumAuthorisationAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximumAuthorisationAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MaximumAuthorisationAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FundedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingCurrencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FundingCurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fxRate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RCNAlias");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RCNAlias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RCNDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RCNDescription"));
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
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
