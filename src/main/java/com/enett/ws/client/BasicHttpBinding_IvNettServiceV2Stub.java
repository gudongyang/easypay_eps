/**
 * BasicHttpBinding_IvNettServiceV2Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class BasicHttpBinding_IvNettServiceV2Stub extends org.apache.axis.client.Stub implements IvNettServiceV2 {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IssueVAN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "issueVANRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssueVANRequest"), IssueVANRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssueVANResponse"));
        oper.setReturnClass(IssueVANResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "IssueVANResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AmendVAN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "amendVANRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANRequest"), AmendVANRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANResponse"));
        oper.setReturnClass(AmendVANResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "AmendVANResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelVAN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "cancelVANRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CancelVANRequest"), CancelVANRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CancelVANResponse"));
        oper.setReturnClass(CancelVANResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "CancelVANResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CloseVAN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "closeVANRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CloseVANRequest"), CloseVANRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CloseVANResponse"));
        oper.setReturnClass(CloseVANResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "CloseVANResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetVANDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "getVANRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetVANRequest"), GetVANRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetVANResponse"));
        oper.setReturnClass(GetVANResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "GetVANDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetFxQuote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "getVNettFxQuoteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetFxQuoteRequest"), GetFxQuoteRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetFxQuoteResponse"));
        oper.setReturnClass(GetFxQuoteResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "GetFxQuoteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

    }

    public BasicHttpBinding_IvNettServiceV2Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IvNettServiceV2Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IvNettServiceV2Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "FxHistoryCollection");
            cachedSerQNames.add(qName);
            cls = FxHistory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxHistory");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "FxHistory");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "VanHistoryCollection");
            cachedSerQNames.add(qName);
            cls = VanHistory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VanHistory");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/eNett.PublicServices.vNett.Host.ViewModels.v2", "VanHistory");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.enett.com/services/vnett/2010/09", "CancelReasonType");
            cachedSerQNames.add(qName);
            cls = CancelReasonType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANRequest");
            cachedSerQNames.add(qName);
            cls = AmendVANRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "AmendVANResponse");
            cachedSerQNames.add(qName);
            cls = AmendVANResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CancelVANRequest");
            cachedSerQNames.add(qName);
            cls = CancelVANRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CancelVANResponse");
            cachedSerQNames.add(qName);
            cls = CancelVANResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CloseVANRequest");
            cachedSerQNames.add(qName);
            cls = CloseVANRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "CloseVANResponse");
            cachedSerQNames.add(qName);
            cls = CloseVANResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "FxHistory");
            cachedSerQNames.add(qName);
            cls = FxHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetFxQuoteRequest");
            cachedSerQNames.add(qName);
            cls = GetFxQuoteRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetFxQuoteResponse");
            cachedSerQNames.add(qName);
            cls = GetFxQuoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetVANRequest");
            cachedSerQNames.add(qName);
            cls = GetVANRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "GetVANResponse");
            cachedSerQNames.add(qName);
            cls = GetVANResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssueVANRequest");
            cachedSerQNames.add(qName);
            cls = IssueVANRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "IssueVANResponse");
            cachedSerQNames.add(qName);
            cls = IssueVANResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference");
            cachedSerQNames.add(qName);
            cls = UserReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReferenceCollection");
            cachedSerQNames.add(qName);
            cls = UserReference[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference");
            qName2 = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "UserReference");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://www.enett.com/services/messages/2013/11", "VanHistory");
            cachedSerQNames.add(qName);
            cls = VanHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public IssueVANResponse issueVAN(IssueVANRequest issueVANRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("IssueVANRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "IssueVAN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {issueVANRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (IssueVANResponse) _resp;
            } catch (Exception _exception) {
                return (IssueVANResponse) org.apache.axis.utils.JavaUtils.convert(_resp, IssueVANResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public AmendVANResponse amendVAN(AmendVANRequest amendVANRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AmendVANRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "AmendVAN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {amendVANRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AmendVANResponse) _resp;
            } catch (Exception _exception) {
                return (AmendVANResponse) org.apache.axis.utils.JavaUtils.convert(_resp, AmendVANResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CancelVANResponse cancelVAN(CancelVANRequest cancelVANRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("CancelVANRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "CancelVAN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {cancelVANRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CancelVANResponse) _resp;
            } catch (Exception _exception) {
                return (CancelVANResponse) org.apache.axis.utils.JavaUtils.convert(_resp, CancelVANResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CloseVANResponse closeVAN(CloseVANRequest closeVANRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("CloseVANRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "CloseVAN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {closeVANRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CloseVANResponse) _resp;
            } catch (Exception _exception) {
                return (CloseVANResponse) org.apache.axis.utils.JavaUtils.convert(_resp, CloseVANResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public GetVANResponse getVANDetails(GetVANRequest getVANRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetVANRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "GetVANDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getVANRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetVANResponse) _resp;
            } catch (Exception _exception) {
                return (GetVANResponse) org.apache.axis.utils.JavaUtils.convert(_resp, GetVANResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public GetFxQuoteResponse getFxQuote(GetFxQuoteRequest getVNettFxQuoteRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetFxQuoteRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "GetFxQuote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getVNettFxQuoteRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetFxQuoteResponse) _resp;
            } catch (Exception _exception) {
                return (GetFxQuoteResponse) org.apache.axis.utils.JavaUtils.convert(_resp, GetFxQuoteResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
