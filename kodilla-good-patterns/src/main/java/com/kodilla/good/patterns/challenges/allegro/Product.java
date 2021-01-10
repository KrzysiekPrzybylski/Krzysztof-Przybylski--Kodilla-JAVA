package com.kodilla.good.patterns.challenges.allegro;

import java.math.BigDecimal;

abstract class Product {

    private String productName;
    private String productDistribution;
    private BigDecimal productPrice;

    public Product(String productName, String productDistribution, BigDecimal productPrice) {
        this.productName = productName;
        this.productDistribution = productDistribution;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "productName='" + productName + '\'' +
                ", productDistribution='" + productDistribution + '\'' +
                ", productPrice=" + productPrice;
    }
}
