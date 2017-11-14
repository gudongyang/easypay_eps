/**
 * FxHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class FxHistory  implements java.io.Serializable {
    private String dateTime;

    private String user;

    private String sellCurrencyCode;

    private String buyCurrencyCode;

    private long sellAmount;

    private long buyAmount;

    private java.math.BigDecimal rate;

    public FxHistory() {
    }

    public FxHistory(
           String dateTime,
           String user,
           String sellCurrencyCode,
           String buyCurrencyCode,
           long sellAmount,
           long buyAmount,
           java.math.BigDecimal rate) {
           this.dateTime = dateTime;
           this.user = user;
           this.sellCurrencyCode = sellCurrencyCode;
           this.buyCurrencyCode = buyCurrencyCode;
           this.sellAmount = sellAmount;
           this.buyAmount = buyAmount;
           this.rate = rate;
    }


    /**
     * Gets the dateTime value for this FxHistory.
     * 
     * @return dateTime
     */
    public String getDateTime() {
        return dateTime;
    }


    /**
     * Sets the dateTime value for this FxHistory.
     * 
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * Gets the user value for this FxHistory.
     * 
     * @return user
     */
    public String getUser() {
        return user;
    }


    /**
     * Sets the user value for this FxHistory.
     * 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }


    /**
     * Gets the sellCurrencyCode value for this FxHistory.
     * 
     * @return sellCurrencyCode
     */
    public String getSellCurrencyCode() {
        return sellCurrencyCode;
    }


    /**
     * Sets the sellCurrencyCode value for this FxHistory.
     * 
     * @param sellCurrencyCode
     */
    public void setSellCurrencyCode(String sellCurrencyCode) {
        this.sellCurrencyCode = sellCurrencyCode;
    }


    /**
     * Gets the buyCurrencyCode value for this FxHistory.
     * 
     * @return buyCurrencyCode
     */
    public String getBuyCurrencyCode() {
        return buyCurrencyCode;
    }


    /**
     * Sets the buyCurrencyCode value for this FxHistory.
     * 
     * @param buyCurrencyCode
     */
    public void setBuyCurrencyCode(String buyCurrencyCode) {
        this.buyCurrencyCode = buyCurrencyCode;
    }


    /**
     * Gets the sellAmount value for this FxHistory.
     * 
     * @return sellAmount
     */
    public long getSellAmount() {
        return sellAmount;
    }


    /**
     * Sets the sellAmount value for this FxHistory.
     * 
     * @param sellAmount
     */
    public void setSellAmount(long sellAmount) {
        this.sellAmount = sellAmount;
    }


    /**
     * Gets the buyAmount value for this FxHistory.
     * 
     * @return buyAmount
     */
    public long getBuyAmount() {
        return buyAmount;
    }


    /**
     * Sets the buyAmount value for this FxHistory.
     * 
     * @param buyAmount
     */
    public void setBuyAmount(long buyAmount) {
        this.buyAmount = buyAmount;
    }


    /**
     * Gets the rate value for this FxHistory.
     * 
     * @return rate
     */
    public java.math.BigDecimal getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this FxHistory.
     * 
     * @param rate
     */
    public void setRate(java.math.BigDecimal rate) {
        this.rate = rate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof FxHistory)) return false;
        FxHistory other = (FxHistory) obj;
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
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.sellCurrencyCode==null && other.getSellCurrencyCode()==null) || 
             (this.sellCurrencyCode!=null &&
              this.sellCurrencyCode.equals(other.getSellCurrencyCode()))) &&
            ((this.buyCurrencyCode==null && other.getBuyCurrencyCode()==null) || 
             (this.buyCurrencyCode!=null &&
              this.buyCurrencyCode.equals(other.getBuyCurrencyCode()))) &&
            this.sellAmount == other.getSellAmount() &&
            this.buyAmount == other.getBuyAmount() &&
            ((this.rate==null && other.getRate()==null) || 
             (this.rate!=null &&
              this.rate.equals(other.getRate())));
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
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getSellCurrencyCode() != null) {
            _hashCode += getSellCurrencyCode().hashCode();
        }
        if (getBuyCurrencyCode() != null) {
            _hashCode += getBuyCurrencyCode().hashCode();
        }
        _hashCode += new Long(getSellAmount()).hashCode();
        _hashCode += new Long(getBuyAmount()).hashCode();
        if (getRate() != null) {
            _hashCode += getRate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FxHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "DateTime"));
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
        elemField.setFieldName("sellCurrencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SellCurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyCurrencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "BuyCurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "SellAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "BuyAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "Rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
