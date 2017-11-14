/**
 * CancelVANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class CancelVANResponse  implements java.io.Serializable {
    private Boolean isSuccessful;

    private Integer errorCode;

    private String errorDescription;

    private String supportLogId;

    private Integer VNettTransactionID;

    public CancelVANResponse() {
    }

    public CancelVANResponse(
           Boolean isSuccessful,
           Integer errorCode,
           String errorDescription,
           String supportLogId,
           Integer VNettTransactionID) {
           this.isSuccessful = isSuccessful;
           this.errorCode = errorCode;
           this.errorDescription = errorDescription;
           this.supportLogId = supportLogId;
           this.VNettTransactionID = VNettTransactionID;
    }


    /**
     * Gets the isSuccessful value for this CancelVANResponse.
     * 
     * @return isSuccessful
     */
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }


    /**
     * Sets the isSuccessful value for this CancelVANResponse.
     * 
     * @param isSuccessful
     */
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }


    /**
     * Gets the errorCode value for this CancelVANResponse.
     * 
     * @return errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this CancelVANResponse.
     * 
     * @param errorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDescription value for this CancelVANResponse.
     * 
     * @return errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this CancelVANResponse.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the supportLogId value for this CancelVANResponse.
     * 
     * @return supportLogId
     */
    public String getSupportLogId() {
        return supportLogId;
    }


    /**
     * Sets the supportLogId value for this CancelVANResponse.
     * 
     * @param supportLogId
     */
    public void setSupportLogId(String supportLogId) {
        this.supportLogId = supportLogId;
    }


    /**
     * Gets the VNettTransactionID value for this CancelVANResponse.
     * 
     * @return VNettTransactionID
     */
    public Integer getVNettTransactionID() {
        return VNettTransactionID;
    }


    /**
     * Sets the VNettTransactionID value for this CancelVANResponse.
     * 
     * @param VNettTransactionID
     */
    public void setVNettTransactionID(Integer VNettTransactionID) {
        this.VNettTransactionID = VNettTransactionID;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CancelVANResponse)) return false;
        CancelVANResponse other = (CancelVANResponse) obj;
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
            ((this.VNettTransactionID==null && other.getVNettTransactionID()==null) || 
             (this.VNettTransactionID!=null &&
              this.VNettTransactionID.equals(other.getVNettTransactionID())));
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
        if (getVNettTransactionID() != null) {
            _hashCode += getVNettTransactionID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelVANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CancelVANResponse"));
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
        elemField.setFieldName("VNettTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VNettTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
