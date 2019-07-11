package com.maciej.hellowebservice.soap.config;

import com.maciej.hellowebservice.HelloWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;    // CXF bus

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new HelloWS()); // CXF provides implementation for this Endpoint interface
        endpoint.publish("/hello");
        return endpoint;
    }
}
