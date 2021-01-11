package com.kodilla.good.patterns.Food2Door;

import java.util.List;

public class OrderService {

    public void processAllOrder(List<OrderRequest> orderRequest) {

        orderRequest.stream()
                .map( n -> {
                    System.out.println("We're processing your order " + n.getCustomer().getName());
                    return n.getFoodProducer().process(n.getCustomer(),n.getProductOrderRequest());
                })
                .forEach( m -> System.out.println("Order finished with success: " + m + "\n"));
    }
}
