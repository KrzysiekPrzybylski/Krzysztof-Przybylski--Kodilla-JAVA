package com.kodilla.good.patterns.Food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MeatShop implements FoodProducer{
    private Map<Product,Integer> productsList;


    private Map<Product,Integer> createProductList() {
        productsList = new HashMap<>();

        productsList.put(new MeatProduct("Knuckle", "Pork"), 100);
        productsList.put(new MeatProduct("Steak","Beef"), 0);
        productsList.put(new MeatProduct("Giblets","Chicken"), 144);
        productsList.put(new MeatProduct("Minced meat", "Beef and Pork"), 300);


        return productsList;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {

        for (Map.Entry<Product, Integer> entry: productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("This product is unavailable");
                return false;

            }
        }
        return true;
    }
}
