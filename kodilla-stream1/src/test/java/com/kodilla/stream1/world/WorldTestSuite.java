package com.kodilla.stream1.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent northAmerica = new Continent("North America");

        Country poland = new Country("Poland", new BigDecimal("48000000"));
        Country germany = new Country("Germany", new BigDecimal("89000000"));
        Country france = new Country("France", new BigDecimal("78000000"));
        Country russia = new Country("Russia", new BigDecimal("144000000"));
        Country mongolia = new Country("Mongolia", new BigDecimal("46000000"));
        Country china = new Country("China", new BigDecimal("1700000000"));
        Country usa = new Country("USA", new BigDecimal("36000000"));

        //When
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        asia.addCountry(russia);
        asia.addCountry(china);
        asia.addCountry(mongolia);
        northAmerica.addCountry(usa);

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        //Then
        BigDecimal expectedPeopleOnTheWorld = new BigDecimal("2141000000");
        BigDecimal resultPeopleOnTheWorld = world.getPeopleQuantity();
        Assertions.assertEquals(expectedPeopleOnTheWorld,resultPeopleOnTheWorld);




    }
}
