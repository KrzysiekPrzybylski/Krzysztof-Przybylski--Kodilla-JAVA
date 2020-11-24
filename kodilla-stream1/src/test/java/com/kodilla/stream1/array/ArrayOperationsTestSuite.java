package com.kodilla.stream1.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = {5,2,4,3,4,6,4,8};

        //When
        Double average = ArrayOperation.getAverage(numbers);

        //Then
        assertEquals((4.5),average,0.0);

    }
}
