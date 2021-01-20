package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openLogger() {
        logger = Logger.USER;
        logger.log("new logger");
    }

    @Test
    void testGetLog() {
        //Given
        //When
        String result = logger.getLastLog();
        //Then
        Assertions.assertEquals("new logger", result);
    }

}
