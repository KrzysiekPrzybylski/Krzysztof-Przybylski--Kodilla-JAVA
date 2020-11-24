package com.kodilla.stream1.world;

import java.math.BigDecimal;

public final class Country {

    private final String countryName;
    private final BigDecimal peopleQty;

    public Country(String countryName, BigDecimal peopleQty) {
        this.countryName = countryName;
        this.peopleQty = peopleQty;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQty() {
        return peopleQty;
    }


    public BigDecimal getPeopleQuantity() {
        return peopleQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!countryName.equals(country.countryName)) return false;
        return peopleQty.equals(country.peopleQty);
    }

    @Override
    public int hashCode() {
        int result = countryName.hashCode();
        result = 31 * result + peopleQty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", peopleQty=" + peopleQty +
                '}';
    }
}
