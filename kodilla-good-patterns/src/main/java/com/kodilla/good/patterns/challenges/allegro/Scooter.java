package com.kodilla.good.patterns.challenges.allegro;

import java.math.BigDecimal;

public class Scooter extends Product{

    private String scooterSize;


    public Scooter(String productName, String productDistribution, BigDecimal productPrice, String scooterSize) {
        super(productName, productDistribution, productPrice);
        this.scooterSize = scooterSize;
    }
    public String getScooterSize() {
        return scooterSize;
    }
}

