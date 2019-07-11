package com.maciej.UserTokenClient.client;

import com.bharath.ws.soap.PaymentProcessor;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;

import java.net.MalformedURLException;
import java.net.URL;

public class PaymentWSClient {

    public static void main(String[] args) throws MalformedURLException {

        PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentprocessor?wsdl"));
        PaymentProcessor paymentProcessorImplPort = service.getPaymentProcessorImplPort();

        PaymentProcessorResponse response = paymentProcessorImplPort.processPayment(new PaymentProcessorRequest());
        System.out.println(response.isResult());

    }
}
