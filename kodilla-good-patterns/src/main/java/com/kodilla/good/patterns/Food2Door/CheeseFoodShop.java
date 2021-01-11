package com.kodilla.good.patterns.Food2Door;

import java.util.*;

public class CheeseFoodShop implements FoodProducer{

    private Map<Product,Integer> productCheeseList;


    public CheeseFoodShop() {
        productCheeseList = createProductCheeseList();

    }

    private Map<Product, Integer> createProductCheeseList() {
        Map<Product, Integer> productCheeseList = new HashMap<>();

        productCheeseList.put(new CheeseProduct("Cottage chesse", "Cow's milk"), 140);
        productCheeseList.put(new CheeseProduct("Camembert","Cow's milk"), 400);
        productCheeseList.put(new CheeseProduct("Gorgonzola","Sheep's milk"), 320);

        return  productCheeseList;
    }


    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        return (productsOrders.size() >= 2 && isProductsAvailable(productsOrders));
    }

    private boolean isProductsAvailable(Map<Product, Integer> productsOrders) {
        for (Map.Entry<Product, Integer> entry: productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productCheeseList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("This product is unavailable");
                return false;

            }
        }
        return true;

    }
}
