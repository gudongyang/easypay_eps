/**
 * AmendVANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class AmendVANResponse  implements java.io.Serializable {
    private Boolean isSuccessful;

    private Integer errorCode;

    private String errorDescription;

    private String supportLogId;

    private String activationDate;

    private String expiryDate;

    private String fullExpiryDate;

    private int VNettTransactionID;

    private String cardSecurityCode;

    private java.math.BigDecimal fxRate;

    public AmendVANResponse() {
    }

    public AmendVANResponse(
           Boolean isSuccessful,
           Integer errorCode,
           String errorDescription,
           String supportLogId,
           String activationDate,
           String expiryDate,
           String fullExpiryDate,
           int VNettTransactionID,
           String cardSecurityCode,
           java.math.BigDecimal fxRate) {
           this.isSuccessful = isSuccessful;
           this.errorCode = errorCode;
           this.errorDescription = errorDescription;
           this.supportLogId = supportLogId;
           this.activationDate = activationDate;
           this.expiryDate = expiryDate;
           this.fullExpiryDate = fullExpiryDate;
           this.VNettTransactionID = VNettTransactionID;
           this.cardSecurityCode = cardSecurityCode;
           this.fxRate = fxRate;
    }


    /**
     * Gets the isSuccessful value for this AmendVANResponse.
     * 
     * @return isSuccessful
     */
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }


    /**
     * Sets the isSuccessful value for this AmendVANResponse.
     * 
     * @param isSuccessful
     */
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }


    /**
     * Gets the errorCode value for this AmendVANResponse.
     * 
     * @return errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this AmendVANResponse.
     * 
     * @param errorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDescription value for this AmendVANResponse.
     * 
     * @return errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this AmendVANResponse.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the supportLogId value for this AmendVANResponse.
     * 
     * @return supportLogId
     */
    public String getSupportLogId() {
        return supportLogId;
    }


    /**
     * Sets the supportLogId value for this AmendVANResponse.
     * 
     * @param supportLogId
     */
    public void setSupportLogId(String supportLogId) {
        this.supportLogId = supportLogId;
    }


    /**
     * Gets the activationDate value for this AmendVANResponse.
     * 
     * @return activationDate
     */
    public String getActivationDate() {
        return activationDate;
    }


    /**
     * Sets the activationDate value for this AmendVANResponse.
     * 
     * @param activationDate
     */
    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }


    /**
     * Gets the expiryDate value for this AmendVANResponse.
     * 
     * @return expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiryDate value for this AmendVANResponse.
     * 
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    /**
     * Gets the fullExpiryDate value for this AmendVANResponse.
     * 
     * @return fullExpiryDate
     */
    public String getFullExpiryDate() {
        return fullExpiryDate;
    }


    /**
     * Sets the fullExpiryDate value for this AmendVANResponse.
     * 
     * @param fullExpiryDate
     */
    public void setFullExpiryDate(String fullExpiryDate) {
        this.fullExpiryDate = fullExpiryDate;
    }


    /**
     * Gets the VNettTransactionID value for this AmendVANResponse.
     * 
     * @return VNettTransactionID
     */
    public int getVNettTransactionID() {
        return VNettTransactionID;
    }


    /**
     * Sets the VNettTransactionID value for this AmendVANResponse.
     * 
     * @param VNettTransactionID
     */
    public void setVNettTransactionID(int VNettTransactionID) {
        this.VNettTransactionID = VNettTransactionID;
    }


    /**
     * Gets the cardSecurityCode value for this AmendVANResponse.
     * 
     * @return cardSecurityCode
     */
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }


    /**
     * Sets the cardSecurityCode value for this AmendVANResponse.
     * 
     * @param cardSecurityCode
     */
    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }


    /**
     * Gets the fxRate value for this AmendVANResponse.
     * 
     * @return fxRate
     */
    public java.math.BigDecimal getFxRate() {
        return fxRate;
    }


    /**
     * Sets the fxRate value for this AmendVANResponse.
     * 
     * @param fxRate
     */
    public void setFxRate(java.math.BigDecimal fxRate) {
        this.fxRate = fxRate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AmendVANResponse)) return false;
        AmendVANResponse other = (AmendVANResponse) obj;
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
            ((this.expiryDate==null && other.getExpiryDate()==null) || 
             (this.expiryDate!=null &&
              this.expiryDate.equals(other.getExpiryDate()))) &&
            ((this.fullExpiryDate==null && other.getFullExpiryDate()==null) || 
             (this.fullExpiryDate!=null &&
              this.fullExpiryDate.equals(other.getFullExpiryDate()))) &&
            this.VNettTransactionID == other.getVNettTransactionID() &&
            ((this.cardSecurityCode==null && other.getCardSecurityCode()==null) || 
             (this.cardSecurityCode!=null &&
              this.cardSecurityCode.equals(other.getCardSecurityCode()))) &&
            ((this.fxRate==null && other.getFxRate()==null) || 
             (this.fxRate!=null &&
              this.fxRate.equals(other.getFxRate())));
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
        if (getExpiryDate() != null) {
            _hashCode += getExpiryDate().hashCode();
        }
        if (getFullExpiryDate() != null) {
            _hashCode += getFullExpiryDate().hashCode();
        }
        _hashCode += getVNettTransactionID();
        if (getCardSecurityCode() != null) {
            _hashCode += getCardSecurityCode().hashCode();
        }
        if (getFxRate() != null) {
            _hashCode += getFxRate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AmendVANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANResponse"));
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
        elemField.setFieldName("expiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ExpiryDate"));
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
        elemField.setFieldName("VNettTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VNettTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardSecurityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CardSecurityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fxRate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
