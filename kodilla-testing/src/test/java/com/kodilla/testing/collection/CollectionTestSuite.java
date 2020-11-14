package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
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
        List<Integer> randomLists = new ArrayList<>();
        randomLists.add(14);
        randomLists.add(15);
        randomLists.add(33);
        randomLists.add(35);
        randomLists.add(36);
        randomLists.add(48);

        List<Integer> random1 = new ArrayList<>();
        random1.add(14);
        random1.add(36);
        random1.add(48);

        //When
        List<Integer> expectedResult = random1;
        List<Integer> result = odd.exterminate(randomLists);

        //Then
        Assertions.assertEquals(expectedResult,result);
    }
}
