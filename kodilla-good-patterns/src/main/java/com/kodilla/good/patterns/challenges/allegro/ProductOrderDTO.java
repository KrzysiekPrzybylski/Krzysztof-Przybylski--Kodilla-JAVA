package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class ProductOrderDTO {

    private User user;
    private Product product;
    private LocalDateTime orderDate;
    private int quantity;
    private boolean isSold;

    public ProductOrderDTO(final User user, final Product product, final LocalDateTime orderDate, final int quantity, final boolean isSold) {
        this.user = user;
        this.product = product;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.isSold = isSold;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSold() {
        return isSold;
    }

}
