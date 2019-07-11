package com.maciej.javasoapclient;

import com.maciej.*;
import com.maciej.wsdlfirstws.CustomerOrdersWsImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrderWsClient {

    public static void main(String[] args) throws MalformedURLException {

        // Create CustomerOrdersService stub; Under the hood the Service Provider mechanism is used (delegate Service field is assigned) - MAGIC HAPPENS.
        CustomerOrdersWsImplService wsService = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));

        // Delegate generates entire code at runtime that can be used to de/serialize SOAP messages, call the appropriate web service endpoint and return response back.
        CustomerOrdersPortType customerOrdersWsImplPort = wsService.getCustomerOrdersWsImplPort();

        CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
        createOrdersRequest.setCustomerId(BigInteger.ONE);
        createOrdersRequest.setOrder(new Order());
        CreateOrdersResponse createOrdersResponse = customerOrdersWsImplPort.createOrders(createOrdersRequest);
        boolean isSuccess = createOrdersResponse.isResult();

        System.out.println("Added order for customer, is it successful?: " + isSuccess);

        GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
        getOrdersRequest.setCustomerId(BigInteger.ONE);
        GetOrdersResponse ordersResponse = customerOrdersWsImplPort.getOrders(getOrdersRequest);
        List<Order> orders = ordersResponse.getOrder();

        System.out.println("Number of orders for the customer is: " + orders.size());
    }
}
