package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;
import java.util.Random;

public class ScooterOrderRepository implements ProductOrderRepository {

    @Override
    public boolean createProductOrder(User user, LocalDateTime orderDate, Product product, int quantity) {
        return new Random().nextBoolean();
    }
}
