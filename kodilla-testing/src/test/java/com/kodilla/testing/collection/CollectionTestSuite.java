package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Checking list numbers");
    }
    @AfterEach
    public void after() {
        System.out.println("Test Case: end");

    }
    @DisplayName(
            "when create List without number" +
            "then exterminate List should be empty"
    )
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> emptyLists = new ArrayList<>();
        OddNumbersExterinator odd = new OddNumbersExterinator();

        //When
        List<Integer> result = odd.exterminate(emptyLists);
        //Then
        Assertions.assertEquals(emptyLists, result);

    }
    @DisplayName(
            "when create List with value," +
            "then exterminate List should return evens number"
    )
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterinator odd = new OddNumbersExterinator();
        List<Integer> randomLists = Arrays.asList(14,15,33,35,36,48);

        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(14);
        expectedResult.add(36);
        expectedResult.add(48);

        //When
        List<Integer> result = odd.exterminate(randomLists);

        //Then
        Assertions.assertEquals(expectedResult,result);
    }
}
