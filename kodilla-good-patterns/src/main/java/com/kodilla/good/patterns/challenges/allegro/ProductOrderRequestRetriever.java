package com.kodilla.good.patterns.challenges.allegro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve() {
        User user = new User("Carl", "Stefan", "Czarny");
        LocalDateTime orderDate = LocalDateTime.of(2020,10,5,10,40);
        Product product = new Scooter("Black","Good Price", new BigDecimal(456), "XXL");
        int quantity = 1;

        System.out.println("Retrieve product request:");
        System.out.println("User - " + user.getUserName() + ", Date - " + orderDate +"\n" + "Product: " + product + "quantity " + quantity);

        return new ProductOrderRequest(user, orderDate, product, quantity);
    }
}
