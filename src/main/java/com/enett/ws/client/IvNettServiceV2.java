/**
 * IvNettServiceV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.enett.ws.client;

public interface IvNettServiceV2 extends java.rmi.Remote {
    public com.enett.ws.client.IssueVANResponse issueVAN(IssueVANRequest issueVANRequest) throws java.rmi.RemoteException;
    public com.enett.ws.client.AmendVANResponse amendVAN(AmendVANRequest amendVANRequest) throws java.rmi.RemoteException;
    public com.enett.ws.client.CancelVANResponse cancelVAN(com.enett.ws.client.CancelVANRequest cancelVANRequest) throws java.rmi.RemoteException;
    public com.enett.ws.client.CloseVANResponse closeVAN(CloseVANRequest closeVANRequest) throws java.rmi.RemoteException;
    public GetVANResponse getVANDetails(GetVANRequest getVANRequest) throws java.rmi.RemoteException;
    public com.enett.ws.client.GetFxQuoteResponse getFxQuote(com.enett.ws.client.GetFxQuoteRequest getVNettFxQuoteRequest) throws java.rmi.RemoteException;
}
