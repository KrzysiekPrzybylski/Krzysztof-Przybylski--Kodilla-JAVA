package com.kodilla.stream1.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {

    private final List<Continent> listOfContinents = new ArrayList<>();

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantityOnTheWorld = listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountryOnContinent().stream())
                .map(Country:: getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum, country) -> sum.add(country));

        return peopleQuantityOnTheWorld;
    }
    public boolean addContinent (Continent continent) {
        return listOfContinents.add(continent);
    }
}
