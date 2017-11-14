/**
 * CancelReasonType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class CancelReasonType implements java.io.Serializable {
    private String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CancelReasonType(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final String _BookingCancelled = "BookingCancelled";
    public static final String _BookingAmended = "BookingAmended";
    public static final String _DuplicateRequest = "DuplicateRequest";
    public static final String _ErrorInOriginalRequest = "ErrorInOriginalRequest";
    public static final String _CreditLimitUpdateFailed = "CreditLimitUpdateFailed";
    public static final String _MaximumToleranceExceeded = "MaximumToleranceExceeded";
    public static final String _FundingFailed = "FundingFailed";
    public static final String _FraudulentUse = "FraudulentUse";
    public static final String _PossibleFraudulentUse = "PossibleFraudulentUse";
    public static final CancelReasonType BookingCancelled = new CancelReasonType(_BookingCancelled);
    public static final CancelReasonType BookingAmended = new CancelReasonType(_BookingAmended);
    public static final CancelReasonType DuplicateRequest = new CancelReasonType(_DuplicateRequest);
    public static final CancelReasonType ErrorInOriginalRequest = new CancelReasonType(_ErrorInOriginalRequest);
    public static final CancelReasonType CreditLimitUpdateFailed = new CancelReasonType(_CreditLimitUpdateFailed);
    public static final CancelReasonType MaximumToleranceExceeded = new CancelReasonType(_MaximumToleranceExceeded);
    public static final CancelReasonType FundingFailed = new CancelReasonType(_FundingFailed);
    public static final CancelReasonType FraudulentUse = new CancelReasonType(_FraudulentUse);
    public static final CancelReasonType PossibleFraudulentUse = new CancelReasonType(_PossibleFraudulentUse);
    public String getValue() { return _value_;}
    public static CancelReasonType fromValue(String value)
          throws IllegalArgumentException {
        CancelReasonType enumeration = (CancelReasonType)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }
    public static CancelReasonType fromString(String value)
          throws IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public String toString() { return _value_;}
    public Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelReasonType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.enett.com/services/vnett/2010/09", "CancelReasonType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
