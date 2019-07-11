package com.maciej.wsdlfirstws;

import com.maciej.*;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.*;

// We do not need to annotate this class because all needed annotations are already defined in the interface
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {

    private Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    private int currentId;

    public CustomerOrdersWsImpl() {
        init();
    }

    private void init() {
        List<Order> orders = new ArrayList<>();

        Order order = new Order();
        order.setId(BigInteger.valueOf(1));

        Product product = new Product();
        product.setId("1");
        product.setDescription("IPhone");
        product.setQuantity(BigInteger.valueOf(3));

        order.getProduct().add(product);
        orders.add(order);

        customerOrders.put(BigInteger.valueOf(++currentId), orders);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orders);
        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        // We assume that the customer is already present
        BigInteger customerId = request.getCustomerId();
        Order order = request.getOrder();

        List<Order> orders = customerOrders.get(customerId);
        orders.add(order);

        CreateOrdersResponse response = new CreateOrdersResponse();
        response.setResult(true);
        return response;
    }

    @Override
    public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        customerOrders.put(customerId, Collections.emptyList());
        DeleteOrdersResponse response = new DeleteOrdersResponse();
        response.setResult(true);
        return response;
    }
}
