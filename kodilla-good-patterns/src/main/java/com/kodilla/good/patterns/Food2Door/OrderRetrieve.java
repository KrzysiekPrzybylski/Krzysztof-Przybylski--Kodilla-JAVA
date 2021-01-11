package com.kodilla.good.patterns.Food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRetrieve {

    public List<OrderRequest> retrieve() {

        List<OrderRequest> orderRequestList = new ArrayList<>();

        Customer customer = new Customer("Maria");
        FoodProducer foodProducer = new CheeseFoodShop();
        Map<Product, Integer> productList = new HashMap<>();
        productList.put(new CheeseProduct("Cottage chesse", "Cow's milk"), 14);
        productList.put(new CheeseProduct("Camembert", "Cow's milk"), 40);
        productList.put(new CheeseProduct("Gorgonzola", "Sheep's milk"), 32);

        orderRequestList.add(new OrderRequest(customer, foodProducer, productList));

        return orderRequestList;

    }
}
