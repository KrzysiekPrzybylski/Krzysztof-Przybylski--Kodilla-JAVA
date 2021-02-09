package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.junit.jupiter.api.Assertions.*;


public class BigMacTestSuite {

    @Test
    void testBigMacBuild() {
        //Given
        BigMac mac = new BigMac.BigMacBuilder()
                .bun("bun with sesame")
                .sauce("garlic sauce")
                .burger("2")
                .sauce("mustard")
                .ingredients("cheese")
                .ingredients("onion")
                .ingredients("cucumber")
                .ingredients("lettuce")
                .build();
        //When
        String amountOfBurgers = mac.getBurgers();
        int amountOfIngredients = mac.getIngredients().size();
        //Then
        assertEquals("2", amountOfBurgers);
        assertEquals(4,amountOfIngredients);
    }
}
