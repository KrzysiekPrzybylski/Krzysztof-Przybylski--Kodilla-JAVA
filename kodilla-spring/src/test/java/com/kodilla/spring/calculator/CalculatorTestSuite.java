package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testAddingZeroToZero() {
        //Given
        //When
        double result = calculator.add(0,0);
        //Then
        assertEquals(0.0,result, 0.01);
    }
    @Test
    void testAddingIntegers(){
        //Given
        // When
        double result = calculator.add(4.0, 4.5);
        // Then
        assertEquals(8.5, result, 0.001);
    }
    @Test
    void testSubtractingZeroFromZero() {
        //Given
        //When
        double result = calculator.sub(0.0, 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }
    @Test
    void testSubtractingAPositiveNumber() {
        //Given
        //When
        double result = calculator.sub(2.5, 5.0);
        //Then
        assertEquals(-2.5, result, 0.001);
    }
    @Test
    void testMultiplyingZeroAndZero() {
        //Given
        //When
        double result = calculator.mul(0.0, 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }
    @Test
    void testMultiplyingTwoPositiveNumbers() {
        //Given
        //When
        double result = calculator.mul(3.0, 2.0);
        //Then
        assertEquals(6.0, result, 0.001);
    }
    @Test
    void testThrowExceptionWhenDividingAPositiveNumberByZero() {
        //Given
        //When & //Then
       assertThrows(Exception.class, () -> calculator.div(2.6,0.0));
    }
    @Test
    void testDividingZeroByANegativeNumber() {
        //Given
        //When
        double result = calculator.div(0.0, -1.025);
        //Then
        assertEquals(0.0, result, 0.001);
    }
    @Test
    void testDividingAPositiveNumberByANegativeNumber() {
        //Given
        //When
        double result = calculator.div(14.0, (-2.0));
        //Then
        assertEquals((-7.0), result, 0.001);
    }

}
