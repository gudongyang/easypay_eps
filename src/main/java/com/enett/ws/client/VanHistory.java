/**
 * VanHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class VanHistory  implements java.io.Serializable {
    private String dateTime;

    private String activityType;

    private String user;

    private String currency;

    private long amount;

    private String details;

    private String subActivityType;

    private Boolean underReview;

    public VanHistory() {
    }

    public VanHistory(
           String dateTime,
           String activityType,
           String user,
           String currency,
           long amount,
           String details,
           String subActivityType,
           Boolean underReview) {
           this.dateTime = dateTime;
           this.activityType = activityType;
           this.user = user;
           this.currency = currency;
           this.amount = amount;
           this.details = details;
           this.subActivityType = subActivityType;
           this.underReview = underReview;
    }


    /**
     * Gets the dateTime value for this VanHistory.
     * 
     * @return dateTime
     */
    public String getDateTime() {
        return dateTime;
    }


    /**
     * Sets the dateTime value for this VanHistory.
     * 
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * Gets the activityType value for this VanHistory.
     * 
     * @return activityType
     */
    public String getActivityType() {
        return activityType;
    }


    /**
     * Sets the activityType value for this VanHistory.
     * 
     * @param activityType
     */
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }


    /**
     * Gets the user value for this VanHistory.
     * 
     * @return user
     */
    public String getUser() {
        return user;
    }


    /**
     * Sets the user value for this VanHistory.
     * 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }


    /**
     * Gets the currency value for this VanHistory.
     * 
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this VanHistory.
     * 
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }


    /**
     * Gets the amount value for this VanHistory.
     * 
     * @return amount
     */
    public long getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this VanHistory.
     * 
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }


    /**
     * Gets the details value for this VanHistory.
     * 
     * @return details
     */
    public String getDetails() {
        return details;
    }


    /**
     * Sets the details value for this VanHistory.
     * 
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }


    /**
     * Gets the subActivityType value for this VanHistory.
     * 
     * @return subActivityType
     */
    public String getSubActivityType() {
        return subActivityType;
    }


    /**
     * Sets the subActivityType value for this VanHistory.
     * 
     * @param subActivityType
     */
    public void setSubActivityType(String subActivityType) {
        this.subActivityType = subActivityType;
    }


    /**
     * Gets the underReview value for this VanHistory.
     * 
     * @return underReview
     */
    public Boolean getUnderReview() {
        return underReview;
    }


    /**
     * Sets the underReview value for this VanHistory.
     * 
     * @param underReview
     */
    public void setUnderReview(Boolean underReview) {
        this.underReview = underReview;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof VanHistory)) return false;
        VanHistory other = (VanHistory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateTime==null && other.getDateTime()==null) || 
             (this.dateTime!=null &&
              this.dateTime.equals(other.getDateTime()))) &&
            ((this.activityType==null && other.getActivityType()==null) || 
             (this.activityType!=null &&
              this.activityType.equals(other.getActivityType()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            this.amount == other.getAmount() &&
            ((this.details==null && other.getDetails()==null) || 
             (this.details!=null &&
              this.details.equals(other.getDetails()))) &&
            ((this.subActivityType==null && other.getSubActivityType()==null) || 
             (this.subActivityType!=null &&
              this.subActivityType.equals(other.getSubActivityType()))) &&
            ((this.underReview==null && other.getUnderReview()==null) || 
             (this.underReview!=null &&
              this.underReview.equals(other.getUnderReview())));
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
        if (getDateTime() != null) {
            _hashCode += getDateTime().hashCode();
        }
        if (getActivityType() != null) {
            _hashCode += getActivityType().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        _hashCode += new Long(getAmount()).hashCode();
        if (getDetails() != null) {
            _hashCode += getDetails().hashCode();
        }
        if (getSubActivityType() != null) {
            _hashCode += getSubActivityType().hashCode();
        }
        if (getUnderReview() != null) {
            _hashCode += getUnderReview().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VanHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VanHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "DateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activityType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "ActivityType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "User"));
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
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("details");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subActivityType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SubActivityType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underReview");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UnderReview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
