package com.kodilla.good.patterns.Food2Door;

public class Foord2Door {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        orderService.processAllOrder(new OrderRetrieve().retrieve());
    }
}
