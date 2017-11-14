/**
 * AmendVANRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class AmendVANRequest  implements java.io.Serializable {
    private String integratorCode;

    private String integratorAccessKey;

    private int requesterEcn;

    private String messageDigest;

    private String activationDate;

    private String expiryDate;

    private String integratorReference;

    private boolean isInstantAuthRequired;

    private Boolean isMultiUse;

    private int issuedToEcn;

    private long maximumAuthorisationAmount;

    private String merchantCategoryCode;

    private String merchantCategoryName;

    private Boolean allow3Ds;

    private long minimumAuthorisationAmount;

    private Integer multiUseClosePercentage;

    private String notes;

    private String username;

    private String fundingCurrencyCode;

    private UserReference[] userReferences;

    public AmendVANRequest() {
    }

    public AmendVANRequest(
           String integratorCode,
           String integratorAccessKey,
           int requesterEcn,
           String messageDigest,
           String activationDate,
           String expiryDate,
           String integratorReference,
           boolean isInstantAuthRequired,
           Boolean isMultiUse,
           int issuedToEcn,
           long maximumAuthorisationAmount,
           String merchantCategoryCode,
           String merchantCategoryName,
           Boolean allow3Ds,
           long minimumAuthorisationAmount,
           Integer multiUseClosePercentage,
           String notes,
           String username,
           String fundingCurrencyCode,
           UserReference[] userReferences) {
           this.integratorCode = integratorCode;
           this.integratorAccessKey = integratorAccessKey;
           this.requesterEcn = requesterEcn;
           this.messageDigest = messageDigest;
           this.activationDate = activationDate;
           this.expiryDate = expiryDate;
           this.integratorReference = integratorReference;
           this.isInstantAuthRequired = isInstantAuthRequired;
           this.isMultiUse = isMultiUse;
           this.issuedToEcn = issuedToEcn;
           this.maximumAuthorisationAmount = maximumAuthorisationAmount;
           this.merchantCategoryCode = merchantCategoryCode;
           this.merchantCategoryName = merchantCategoryName;
           this.allow3Ds = allow3Ds;
           this.minimumAuthorisationAmount = minimumAuthorisationAmount;
           this.multiUseClosePercentage = multiUseClosePercentage;
           this.notes = notes;
           this.username = username;
           this.fundingCurrencyCode = fundingCurrencyCode;
           this.userReferences = userReferences;
    }


    /**
     * Gets the integratorCode value for this AmendVANRequest.
     * 
     * @return integratorCode
     */
    public String getIntegratorCode() {
        return integratorCode;
    }


    /**
     * Sets the integratorCode value for this AmendVANRequest.
     * 
     * @param integratorCode
     */
    public void setIntegratorCode(String integratorCode) {
        this.integratorCode = integratorCode;
    }


    /**
     * Gets the integratorAccessKey value for this AmendVANRequest.
     * 
     * @return integratorAccessKey
     */
    public String getIntegratorAccessKey() {
        return integratorAccessKey;
    }


    /**
     * Sets the integratorAccessKey value for this AmendVANRequest.
     * 
     * @param integratorAccessKey
     */
    public void setIntegratorAccessKey(String integratorAccessKey) {
        this.integratorAccessKey = integratorAccessKey;
    }


    /**
     * Gets the requesterEcn value for this AmendVANRequest.
     * 
     * @return requesterEcn
     */
    public int getRequesterEcn() {
        return requesterEcn;
    }


    /**
     * Sets the requesterEcn value for this AmendVANRequest.
     * 
     * @param requesterEcn
     */
    public void setRequesterEcn(int requesterEcn) {
        this.requesterEcn = requesterEcn;
    }


    /**
     * Gets the messageDigest value for this AmendVANRequest.
     * 
     * @return messageDigest
     */
    public String getMessageDigest() {
        return messageDigest;
    }


    /**
     * Sets the messageDigest value for this AmendVANRequest.
     * 
     * @param messageDigest
     */
    public void setMessageDigest(String messageDigest) {
        this.messageDigest = messageDigest;
    }


    /**
     * Gets the activationDate value for this AmendVANRequest.
     * 
     * @return activationDate
     */
    public String getActivationDate() {
        return activationDate;
    }


    /**
     * Sets the activationDate value for this AmendVANRequest.
     * 
     * @param activationDate
     */
    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }


    /**
     * Gets the expiryDate value for this AmendVANRequest.
     * 
     * @return expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiryDate value for this AmendVANRequest.
     * 
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    /**
     * Gets the integratorReference value for this AmendVANRequest.
     * 
     * @return integratorReference
     */
    public String getIntegratorReference() {
        return integratorReference;
    }


    /**
     * Sets the integratorReference value for this AmendVANRequest.
     * 
     * @param integratorReference
     */
    public void setIntegratorReference(String integratorReference) {
        this.integratorReference = integratorReference;
    }


    /**
     * Gets the isInstantAuthRequired value for this AmendVANRequest.
     * 
     * @return isInstantAuthRequired
     */
    public boolean isIsInstantAuthRequired() {
        return isInstantAuthRequired;
    }


    /**
     * Sets the isInstantAuthRequired value for this AmendVANRequest.
     * 
     * @param isInstantAuthRequired
     */
    public void setIsInstantAuthRequired(boolean isInstantAuthRequired) {
        this.isInstantAuthRequired = isInstantAuthRequired;
    }


    /**
     * Gets the isMultiUse value for this AmendVANRequest.
     * 
     * @return isMultiUse
     */
    public Boolean getIsMultiUse() {
        return isMultiUse;
    }


    /**
     * Sets the isMultiUse value for this AmendVANRequest.
     * 
     * @param isMultiUse
     */
    public void setIsMultiUse(Boolean isMultiUse) {
        this.isMultiUse = isMultiUse;
    }


    /**
     * Gets the issuedToEcn value for this AmendVANRequest.
     * 
     * @return issuedToEcn
     */
    public int getIssuedToEcn() {
        return issuedToEcn;
    }


    /**
     * Sets the issuedToEcn value for this AmendVANRequest.
     * 
     * @param issuedToEcn
     */
    public void setIssuedToEcn(int issuedToEcn) {
        this.issuedToEcn = issuedToEcn;
    }


    /**
     * Gets the maximumAuthorisationAmount value for this AmendVANRequest.
     * 
     * @return maximumAuthorisationAmount
     */
    public long getMaximumAuthorisationAmount() {
        return maximumAuthorisationAmount;
    }


    /**
     * Sets the maximumAuthorisationAmount value for this AmendVANRequest.
     * 
     * @param maximumAuthorisationAmount
     */
    public void setMaximumAuthorisationAmount(long maximumAuthorisationAmount) {
        this.maximumAuthorisationAmount = maximumAuthorisationAmount;
    }


    /**
     * Gets the merchantCategoryCode value for this AmendVANRequest.
     * 
     * @return merchantCategoryCode
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }


    /**
     * Sets the merchantCategoryCode value for this AmendVANRequest.
     * 
     * @param merchantCategoryCode
     */
    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }


    /**
     * Gets the merchantCategoryName value for this AmendVANRequest.
     * 
     * @return merchantCategoryName
     */
    public String getMerchantCategoryName() {
        return merchantCategoryName;
    }


    /**
     * Sets the merchantCategoryName value for this AmendVANRequest.
     * 
     * @param merchantCategoryName
     */
    public void setMerchantCategoryName(String merchantCategoryName) {
        this.merchantCategoryName = merchantCategoryName;
    }


    /**
     * Gets the allow3Ds value for this AmendVANRequest.
     * 
     * @return allow3Ds
     */
    public Boolean getAllow3Ds() {
        return allow3Ds;
    }


    /**
     * Sets the allow3Ds value for this AmendVANRequest.
     * 
     * @param allow3Ds
     */
    public void setAllow3Ds(Boolean allow3Ds) {
        this.allow3Ds = allow3Ds;
    }


    /**
     * Gets the minimumAuthorisationAmount value for this AmendVANRequest.
     * 
     * @return minimumAuthorisationAmount
     */
    public long getMinimumAuthorisationAmount() {
        return minimumAuthorisationAmount;
    }


    /**
     * Sets the minimumAuthorisationAmount value for this AmendVANRequest.
     * 
     * @param minimumAuthorisationAmount
     */
    public void setMinimumAuthorisationAmount(long minimumAuthorisationAmount) {
        this.minimumAuthorisationAmount = minimumAuthorisationAmount;
    }


    /**
     * Gets the multiUseClosePercentage value for this AmendVANRequest.
     * 
     * @return multiUseClosePercentage
     */
    public Integer getMultiUseClosePercentage() {
        return multiUseClosePercentage;
    }


    /**
     * Sets the multiUseClosePercentage value for this AmendVANRequest.
     * 
     * @param multiUseClosePercentage
     */
    public void setMultiUseClosePercentage(Integer multiUseClosePercentage) {
        this.multiUseClosePercentage = multiUseClosePercentage;
    }


    /**
     * Gets the notes value for this AmendVANRequest.
     * 
     * @return notes
     */
    public String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this AmendVANRequest.
     * 
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }


    /**
     * Gets the username value for this AmendVANRequest.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this AmendVANRequest.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the fundingCurrencyCode value for this AmendVANRequest.
     * 
     * @return fundingCurrencyCode
     */
    public String getFundingCurrencyCode() {
        return fundingCurrencyCode;
    }


    /**
     * Sets the fundingCurrencyCode value for this AmendVANRequest.
     * 
     * @param fundingCurrencyCode
     */
    public void setFundingCurrencyCode(String fundingCurrencyCode) {
        this.fundingCurrencyCode = fundingCurrencyCode;
    }


    /**
     * Gets the userReferences value for this AmendVANRequest.
     * 
     * @return userReferences
     */
    public UserReference[] getUserReferences() {
        return userReferences;
    }


    /**
     * Sets the userReferences value for this AmendVANRequest.
     * 
     * @param userReferences
     */
    public void setUserReferences(UserReference[] userReferences) {
        this.userReferences = userReferences;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AmendVANRequest)) return false;
        AmendVANRequest other = (AmendVANRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.integratorCode==null && other.getIntegratorCode()==null) || 
             (this.integratorCode!=null &&
              this.integratorCode.equals(other.getIntegratorCode()))) &&
            ((this.integratorAccessKey==null && other.getIntegratorAccessKey()==null) || 
             (this.integratorAccessKey!=null &&
              this.integratorAccessKey.equals(other.getIntegratorAccessKey()))) &&
            this.requesterEcn == other.getRequesterEcn() &&
            ((this.messageDigest==null && other.getMessageDigest()==null) || 
             (this.messageDigest!=null &&
              this.messageDigest.equals(other.getMessageDigest()))) &&
            ((this.activationDate==null && other.getActivationDate()==null) || 
             (this.activationDate!=null &&
              this.activationDate.equals(other.getActivationDate()))) &&
            ((this.expiryDate==null && other.getExpiryDate()==null) || 
             (this.expiryDate!=null &&
              this.expiryDate.equals(other.getExpiryDate()))) &&
            ((this.integratorReference==null && other.getIntegratorReference()==null) || 
             (this.integratorReference!=null &&
              this.integratorReference.equals(other.getIntegratorReference()))) &&
            this.isInstantAuthRequired == other.isIsInstantAuthRequired() &&
            ((this.isMultiUse==null && other.getIsMultiUse()==null) || 
             (this.isMultiUse!=null &&
              this.isMultiUse.equals(other.getIsMultiUse()))) &&
            this.issuedToEcn == other.getIssuedToEcn() &&
            this.maximumAuthorisationAmount == other.getMaximumAuthorisationAmount() &&
            ((this.merchantCategoryCode==null && other.getMerchantCategoryCode()==null) || 
             (this.merchantCategoryCode!=null &&
              this.merchantCategoryCode.equals(other.getMerchantCategoryCode()))) &&
            ((this.merchantCategoryName==null && other.getMerchantCategoryName()==null) || 
             (this.merchantCategoryName!=null &&
              this.merchantCategoryName.equals(other.getMerchantCategoryName()))) &&
            ((this.allow3Ds==null && other.getAllow3Ds()==null) || 
             (this.allow3Ds!=null &&
              this.allow3Ds.equals(other.getAllow3Ds()))) &&
            this.minimumAuthorisationAmount == other.getMinimumAuthorisationAmount() &&
            ((this.multiUseClosePercentage==null && other.getMultiUseClosePercentage()==null) || 
             (this.multiUseClosePercentage!=null &&
              this.multiUseClosePercentage.equals(other.getMultiUseClosePercentage()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.fundingCurrencyCode==null && other.getFundingCurrencyCode()==null) || 
             (this.fundingCurrencyCode!=null &&
              this.fundingCurrencyCode.equals(other.getFundingCurrencyCode()))) &&
            ((this.userReferences==null && other.getUserReferences()==null) || 
             (this.userReferences!=null &&
              java.util.Arrays.equals(this.userReferences, other.getUserReferences())));
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
        if (getIntegratorCode() != null) {
            _hashCode += getIntegratorCode().hashCode();
        }
        if (getIntegratorAccessKey() != null) {
            _hashCode += getIntegratorAccessKey().hashCode();
        }
        _hashCode += getRequesterEcn();
        if (getMessageDigest() != null) {
            _hashCode += getMessageDigest().hashCode();
        }
        if (getActivationDate() != null) {
            _hashCode += getActivationDate().hashCode();
        }
        if (getExpiryDate() != null) {
            _hashCode += getExpiryDate().hashCode();
        }
        if (getIntegratorReference() != null) {
            _hashCode += getIntegratorReference().hashCode();
        }
        _hashCode += (isIsInstantAuthRequired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIsMultiUse() != null) {
            _hashCode += getIsMultiUse().hashCode();
        }
        _hashCode += getIssuedToEcn();
        _hashCode += new Long(getMaximumAuthorisationAmount()).hashCode();
        if (getMerchantCategoryCode() != null) {
            _hashCode += getMerchantCategoryCode().hashCode();
        }
        if (getMerchantCategoryName() != null) {
            _hashCode += getMerchantCategoryName().hashCode();
        }
        if (getAllow3Ds() != null) {
            _hashCode += getAllow3Ds().hashCode();
        }
        _hashCode += new Long(getMinimumAuthorisationAmount()).hashCode();
        if (getMultiUseClosePercentage() != null) {
            _hashCode += getMultiUseClosePercentage().hashCode();
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getFundingCurrencyCode() != null) {
            _hashCode += getFundingCurrencyCode().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AmendVANRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integratorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IntegratorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integratorAccessKey");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IntegratorAccessKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterEcn");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RequesterEcn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageDigest");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MessageDigest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ActivationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("integratorReference");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IntegratorReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInstantAuthRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IsInstantAuthRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMultiUse");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IsMultiUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuedToEcn");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssuedToEcn"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantCategoryName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MerchantCategoryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allow3Ds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Allow3ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("multiUseClosePercentage");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "MultiUseClosePercentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Username"));
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
        elemField.setFieldName("userReferences");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReferences"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference"));
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
