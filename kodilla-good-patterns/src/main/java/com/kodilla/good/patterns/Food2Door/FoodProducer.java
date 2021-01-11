package com.kodilla.good.patterns.Food2Door;

import java.util.Map;

public interface FoodProducer {

    boolean process(Customer customer, Map<Product, Integer> productsOrders);
}
