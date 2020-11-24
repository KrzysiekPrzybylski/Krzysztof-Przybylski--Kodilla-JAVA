package com.kodilla.stream1.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String continentName;
    private final List<Country> listOfCountryOnContinent = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getListOfCountryOnContinent() {
        return new ArrayList<>( listOfCountryOnContinent);
    }
    public boolean addCountry(Country country) {
        return listOfCountryOnContinent.add(country);
    }
}
