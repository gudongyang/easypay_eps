/**
 * VNettServiceV2Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public class VNettServiceV2Locator extends org.apache.axis.client.Service implements VNettServiceV2 {

    public VNettServiceV2Locator() {
    }


    public VNettServiceV2Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VNettServiceV2Locator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IvNettServiceV2
    private String BasicHttpBinding_IvNettServiceV2_address = "https://enett-demo.com/vNettService/vNettServiceV2.svc/RS";

    public String getBasicHttpBinding_IvNettServiceV2Address() {
        return BasicHttpBinding_IvNettServiceV2_address;
    }

    // The WSDD service name defaults to the port name.
    private String BasicHttpBinding_IvNettServiceV2WSDDServiceName = "BasicHttpBinding_IvNettServiceV2";

    public String getBasicHttpBinding_IvNettServiceV2WSDDServiceName() {
        return BasicHttpBinding_IvNettServiceV2WSDDServiceName;
    }

    public void setBasicHttpBinding_IvNettServiceV2WSDDServiceName(String name) {
        BasicHttpBinding_IvNettServiceV2WSDDServiceName = name;
    }

    public IvNettServiceV2 getBasicHttpBinding_IvNettServiceV2() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IvNettServiceV2_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IvNettServiceV2(endpoint);
    }

    public IvNettServiceV2 getBasicHttpBinding_IvNettServiceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.enett.ws.client.BasicHttpBinding_IvNettServiceV2Stub _stub = new com.enett.ws.client.BasicHttpBinding_IvNettServiceV2Stub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IvNettServiceV2WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IvNettServiceV2EndpointAddress(String address) {
        BasicHttpBinding_IvNettServiceV2_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IvNettServiceV2.class.isAssignableFrom(serviceEndpointInterface)) {
                com.enett.ws.client.BasicHttpBinding_IvNettServiceV2Stub _stub = new com.enett.ws.client.BasicHttpBinding_IvNettServiceV2Stub(new java.net.URL(BasicHttpBinding_IvNettServiceV2_address), this);
                _stub.setPortName(getBasicHttpBinding_IvNettServiceV2WSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IvNettServiceV2".equals(inputPortName)) {
            return getBasicHttpBinding_IvNettServiceV2();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "vNettServiceV2");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.enett.com/services/2013/11", "BasicHttpBinding_IvNettServiceV2"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IvNettServiceV2".equals(portName)) {
            setBasicHttpBinding_IvNettServiceV2EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
