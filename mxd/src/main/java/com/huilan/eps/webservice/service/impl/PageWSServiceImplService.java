package com.huilan.eps.webservice.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.huilan.eps.webservice.service.PageWSService;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-10-18T15:45:45.660+08:00
 * Generated source version: 3.2.0
 * 
 */
@WebServiceClient(name = "PageWSServiceImplService", 
                  wsdlLocation = "http://localhost:8080/eps/webservice/page?wsdl",
                  targetNamespace = "http://impl.service.webservice.eps.huilan.com/") 
public class PageWSServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.service.webservice.eps.huilan.com/", "PageWSServiceImplService");
    public final static QName PageWSServiceImplPort = new QName("http://impl.service.webservice.eps.huilan.com/", "PageWSServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/eps/webservice/page?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PageWSServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/eps/webservice/page?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PageWSServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PageWSServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PageWSServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public PageWSServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PageWSServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PageWSServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns PageWSService
     */
    @WebEndpoint(name = "PageWSServiceImplPort")
    public PageWSService getPageWSServiceImplPort() {
        return super.getPort(PageWSServiceImplPort, PageWSService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PageWSService
     */
    @WebEndpoint(name = "PageWSServiceImplPort")
    public PageWSService getPageWSServiceImplPort(WebServiceFeature... features) {
        return super.getPort(PageWSServiceImplPort, PageWSService.class, features);
    }

}
