package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;
import org.apache.cxf.feature.Features;

public class PaymentProcessorImpl implements PaymentProcessor {

    public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
        PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();

        String cardNumber = paymentProcessorRequest.getCreditCardInfo().getCardNumber();
        if (cardNumber == null || cardNumber.length() == 0) {
            throw new ServiceException("Invalid card number");
        }
        // Business Logic or a call to a Business Logic Class Goes Here.
        paymentProcessorResponse.setResult(true);
        return paymentProcessorResponse;
    }

}
