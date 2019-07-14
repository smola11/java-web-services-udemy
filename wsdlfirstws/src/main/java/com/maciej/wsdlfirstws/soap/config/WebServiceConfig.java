package com.maciej.wsdlfirstws.soap.config;

import com.maciej.wsdlfirstws.CustomerOrdersWsImpl;
import com.maciej.wsdlfirstws.handlers.SiteHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWsImpl());
        endpoint.publish("/customerordersservice");

        // Configure Handler chain on the endpoint
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        ArrayList<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SiteHandler());
        binding.setHandlerChain(handlerChain);
        return endpoint;
    }
}
