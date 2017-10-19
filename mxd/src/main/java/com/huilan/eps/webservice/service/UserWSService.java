package com.huilan.eps.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-10-19T15:07:29.362+08:00
 * Generated source version: 3.2.0
 * 
 */
@WebService(targetNamespace = "http://service.webservice.eps.huilan.com/", name = "UserWSService")
@XmlSeeAlso({ObjectFactory.class})
public interface UserWSService {

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://service.webservice.eps.huilan.com/", className = "com.huilan.eps.webservice.service.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://service.webservice.eps.huilan.com/", className = "com.huilan.eps.webservice.service.LoginResponse")
    @WebResult(name = "user", targetNamespace = "")
    public com.huilan.eps.webservice.service.UserInfos login(
        @WebParam(name = "loginProperty", targetNamespace = "")
        com.huilan.eps.webservice.service.LoginProperty loginProperty,
        @WebParam(name = "param", targetNamespace = "")
        com.huilan.eps.webservice.service.Login.Param param
    );
}
