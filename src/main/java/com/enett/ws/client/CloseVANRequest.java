/**
 * CloseVANRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class CloseVANRequest  implements java.io.Serializable {
    private String integratorCode;

    private String integratorAccessKey;

    private int requesterEcn;

    private String messageDigest;

    private String integratorReference;

    private int issuedToEcn;

    private String username;

    public CloseVANRequest() {
    }

    public CloseVANRequest(
           String integratorCode,
           String integratorAccessKey,
           int requesterEcn,
           String messageDigest,
           String integratorReference,
           int issuedToEcn,
           String username) {
           this.integratorCode = integratorCode;
           this.integratorAccessKey = integratorAccessKey;
           this.requesterEcn = requesterEcn;
           this.messageDigest = messageDigest;
           this.integratorReference = integratorReference;
           this.issuedToEcn = issuedToEcn;
           this.username = username;
    }


    /**
     * Gets the integratorCode value for this CloseVANRequest.
     * 
     * @return integratorCode
     */
    public String getIntegratorCode() {
        return integratorCode;
    }


    /**
     * Sets the integratorCode value for this CloseVANRequest.
     * 
     * @param integratorCode
     */
    public void setIntegratorCode(String integratorCode) {
        this.integratorCode = integratorCode;
    }


    /**
     * Gets the integratorAccessKey value for this CloseVANRequest.
     * 
     * @return integratorAccessKey
     */
    public String getIntegratorAccessKey() {
        return integratorAccessKey;
    }


    /**
     * Sets the integratorAccessKey value for this CloseVANRequest.
     * 
     * @param integratorAccessKey
     */
    public void setIntegratorAccessKey(String integratorAccessKey) {
        this.integratorAccessKey = integratorAccessKey;
    }


    /**
     * Gets the requesterEcn value for this CloseVANRequest.
     * 
     * @return requesterEcn
     */
    public int getRequesterEcn() {
        return requesterEcn;
    }


    /**
     * Sets the requesterEcn value for this CloseVANRequest.
     * 
     * @param requesterEcn
     */
    public void setRequesterEcn(int requesterEcn) {
        this.requesterEcn = requesterEcn;
    }


    /**
     * Gets the messageDigest value for this CloseVANRequest.
     * 
     * @return messageDigest
     */
    public String getMessageDigest() {
        return messageDigest;
    }


    /**
     * Sets the messageDigest value for this CloseVANRequest.
     * 
     * @param messageDigest
     */
    public void setMessageDigest(String messageDigest) {
        this.messageDigest = messageDigest;
    }


    /**
     * Gets the integratorReference value for this CloseVANRequest.
     * 
     * @return integratorReference
     */
    public String getIntegratorReference() {
        return integratorReference;
    }


    /**
     * Sets the integratorReference value for this CloseVANRequest.
     * 
     * @param integratorReference
     */
    public void setIntegratorReference(String integratorReference) {
        this.integratorReference = integratorReference;
    }


    /**
     * Gets the issuedToEcn value for this CloseVANRequest.
     * 
     * @return issuedToEcn
     */
    public int getIssuedToEcn() {
        return issuedToEcn;
    }


    /**
     * Sets the issuedToEcn value for this CloseVANRequest.
     * 
     * @param issuedToEcn
     */
    public void setIssuedToEcn(int issuedToEcn) {
        this.issuedToEcn = issuedToEcn;
    }


    /**
     * Gets the username value for this CloseVANRequest.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this CloseVANRequest.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CloseVANRequest)) return false;
        CloseVANRequest other = (CloseVANRequest) obj;
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
            ((this.integratorReference==null && other.getIntegratorReference()==null) || 
             (this.integratorReference!=null &&
              this.integratorReference.equals(other.getIntegratorReference()))) &&
            this.issuedToEcn == other.getIssuedToEcn() &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername())));
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
        if (getIntegratorReference() != null) {
            _hashCode += getIntegratorReference().hashCode();
        }
        _hashCode += getIssuedToEcn();
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CloseVANRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CloseVANRequest"));
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
        elemField.setFieldName("integratorReference");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IntegratorReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuedToEcn");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssuedToEcn"));
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
