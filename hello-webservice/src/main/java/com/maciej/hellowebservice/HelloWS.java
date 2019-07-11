package com.maciej.hellowebservice;

import org.apache.cxf.feature.Features;

import javax.jws.WebMethod;
import javax.jws.WebService;

// We can access: http://localhost:8080/services to see the all services available and WSDL (default behavior)
// We changed it in application.properties
// This javax.jws no longer works with Java 11

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature") // CXF logs SOAP messages into the console
public class HelloWS {

    @WebMethod
    public String hello(){
        return "Hello";
    }
}
