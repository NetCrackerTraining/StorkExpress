/**
 * GetAllUsers.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package clientForCityconService;

public interface GetAllUsers extends java.rmi.Remote {
    public java.lang.String getTestString() throws java.rmi.RemoteException;
    public java.lang.String greet(java.lang.String arg0) throws java.rmi.RemoteException;
    public clientForCityconService.User getTestUser() throws java.rmi.RemoteException;
    public clientForCityconService.User getUserWithLogin(java.lang.String arg0) throws java.rmi.RemoteException;
    public clientForCityconService.User[] getUsers() throws java.rmi.RemoteException;
}
