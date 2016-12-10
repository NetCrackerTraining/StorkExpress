/**
 * GetAllUsersServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package clientForCityconService;

public class GetAllUsersServiceLocator extends org.apache.axis.client.Service implements clientForCityconService.GetAllUsersService {

    public GetAllUsersServiceLocator() {
    }


    public GetAllUsersServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetAllUsersServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GetAllUsersPort
    private java.lang.String GetAllUsersPort_address = "http://citycon.ml:8080/GetAllUsersService";

    public java.lang.String getGetAllUsersPortAddress() {
        return GetAllUsersPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetAllUsersPortWSDDServiceName = "GetAllUsersPort";

    public java.lang.String getGetAllUsersPortWSDDServiceName() {
        return GetAllUsersPortWSDDServiceName;
    }

    public void setGetAllUsersPortWSDDServiceName(java.lang.String name) {
        GetAllUsersPortWSDDServiceName = name;
    }

    public clientForCityconService.GetAllUsers getGetAllUsersPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GetAllUsersPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetAllUsersPort(endpoint);
    }

    public clientForCityconService.GetAllUsers getGetAllUsersPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            clientForCityconService.GetAllUsersPortBindingStub _stub = new clientForCityconService.GetAllUsersPortBindingStub(portAddress, this);
            _stub.setPortName(getGetAllUsersPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetAllUsersPortEndpointAddress(java.lang.String address) {
        GetAllUsersPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (clientForCityconService.GetAllUsers.class.isAssignableFrom(serviceEndpointInterface)) {
                clientForCityconService.GetAllUsersPortBindingStub _stub = new clientForCityconService.GetAllUsersPortBindingStub(new java.net.URL(GetAllUsersPort_address), this);
                _stub.setPortName(getGetAllUsersPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GetAllUsersPort".equals(inputPortName)) {
            return getGetAllUsersPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.citycon.com/", "GetAllUsersService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.citycon.com/", "GetAllUsersPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GetAllUsersPort".equals(portName)) {
            setGetAllUsersPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
