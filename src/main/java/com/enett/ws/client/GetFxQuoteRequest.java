/**
 * GetFxQuoteRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class GetFxQuoteRequest  implements java.io.Serializable {
    private String integratorCode;

    private String integratorAccessKey;

    private int requesterECN;

    private String messageDigest;

    private int clientEcn;

    private String username;

    private String buyCurrency;

    private String sellCurrency;

    public GetFxQuoteRequest() {
    }

    public GetFxQuoteRequest(
           String integratorCode,
           String integratorAccessKey,
           int requesterECN,
           String messageDigest,
           int clientEcn,
           String username,
           String buyCurrency,
           String sellCurrency) {
           this.integratorCode = integratorCode;
           this.integratorAccessKey = integratorAccessKey;
           this.requesterECN = requesterECN;
           this.messageDigest = messageDigest;
           this.clientEcn = clientEcn;
           this.username = username;
           this.buyCurrency = buyCurrency;
           this.sellCurrency = sellCurrency;
    }


    /**
     * Gets the integratorCode value for this GetFxQuoteRequest.
     * 
     * @return integratorCode
     */
    public String getIntegratorCode() {
        return integratorCode;
    }


    /**
     * Sets the integratorCode value for this GetFxQuoteRequest.
     * 
     * @param integratorCode
     */
    public void setIntegratorCode(String integratorCode) {
        this.integratorCode = integratorCode;
    }


    /**
     * Gets the integratorAccessKey value for this GetFxQuoteRequest.
     * 
     * @return integratorAccessKey
     */
    public String getIntegratorAccessKey() {
        return integratorAccessKey;
    }


    /**
     * Sets the integratorAccessKey value for this GetFxQuoteRequest.
     * 
     * @param integratorAccessKey
     */
    public void setIntegratorAccessKey(String integratorAccessKey) {
        this.integratorAccessKey = integratorAccessKey;
    }


    /**
     * Gets the requesterECN value for this GetFxQuoteRequest.
     * 
     * @return requesterECN
     */
    public int getRequesterECN() {
        return requesterECN;
    }


    /**
     * Sets the requesterECN value for this GetFxQuoteRequest.
     * 
     * @param requesterECN
     */
    public void setRequesterECN(int requesterECN) {
        this.requesterECN = requesterECN;
    }


    /**
     * Gets the messageDigest value for this GetFxQuoteRequest.
     * 
     * @return messageDigest
     */
    public String getMessageDigest() {
        return messageDigest;
    }


    /**
     * Sets the messageDigest value for this GetFxQuoteRequest.
     * 
     * @param messageDigest
     */
    public void setMessageDigest(String messageDigest) {
        this.messageDigest = messageDigest;
    }


    /**
     * Gets the clientEcn value for this GetFxQuoteRequest.
     * 
     * @return clientEcn
     */
    public int getClientEcn() {
        return clientEcn;
    }


    /**
     * Sets the clientEcn value for this GetFxQuoteRequest.
     * 
     * @param clientEcn
     */
    public void setClientEcn(int clientEcn) {
        this.clientEcn = clientEcn;
    }


    /**
     * Gets the username value for this GetFxQuoteRequest.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this GetFxQuoteRequest.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the buyCurrency value for this GetFxQuoteRequest.
     * 
     * @return buyCurrency
     */
    public String getBuyCurrency() {
        return buyCurrency;
    }


    /**
     * Sets the buyCurrency value for this GetFxQuoteRequest.
     * 
     * @param buyCurrency
     */
    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }


    /**
     * Gets the sellCurrency value for this GetFxQuoteRequest.
     * 
     * @return sellCurrency
     */
    public String getSellCurrency() {
        return sellCurrency;
    }


    /**
     * Sets the sellCurrency value for this GetFxQuoteRequest.
     * 
     * @param sellCurrency
     */
    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetFxQuoteRequest)) return false;
        GetFxQuoteRequest other = (GetFxQuoteRequest) obj;
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
            this.requesterECN == other.getRequesterECN() &&
            ((this.messageDigest==null && other.getMessageDigest()==null) || 
             (this.messageDigest!=null &&
              this.messageDigest.equals(other.getMessageDigest()))) &&
            this.clientEcn == other.getClientEcn() &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.buyCurrency==null && other.getBuyCurrency()==null) || 
             (this.buyCurrency!=null &&
              this.buyCurrency.equals(other.getBuyCurrency()))) &&
            ((this.sellCurrency==null && other.getSellCurrency()==null) || 
             (this.sellCurrency!=null &&
              this.sellCurrency.equals(other.getSellCurrency())));
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
        _hashCode += getRequesterECN();
        if (getMessageDigest() != null) {
            _hashCode += getMessageDigest().hashCode();
        }
        _hashCode += getClientEcn();
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getBuyCurrency() != null) {
            _hashCode += getBuyCurrency().hashCode();
        }
        if (getSellCurrency() != null) {
            _hashCode += getSellCurrency().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFxQuoteRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetFxQuoteRequest"));
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
        elemField.setFieldName("requesterECN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "RequesterECN"));
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
        elemField.setFieldName("clientEcn");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ClientEcn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "BuyCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SellCurrency"));
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
