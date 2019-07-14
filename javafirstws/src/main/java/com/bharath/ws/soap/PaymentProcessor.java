package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

    @WebMethod
    @WebResult(name = "response")
// this is how it will look in the XML response
    PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest) throws ServiceException;
    // throws ServiceException; - the WSDL contract will change
}
