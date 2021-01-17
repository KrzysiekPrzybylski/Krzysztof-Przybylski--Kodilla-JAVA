package com.kodilla.spring.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;
    @Test
    void testLoadFromDb() {
        //Given


        //When
        library.loadToDB();

        //Then
        //do nothing

    }
    @Test
    void  testSaveToDb() {
        //Given


        //When
        library.saveToDB();

        //Then
        //do nothing
    }


}


