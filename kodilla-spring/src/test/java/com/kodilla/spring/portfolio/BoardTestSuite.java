package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTestSuite {

    @Test
    void testTaskAddToDoList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("task to add");

        //When
        String result = board.getToDoList().getTask(0);

        //Then
        assertEquals("task to add", result);

    }

    @Test
    void testTaskAddInProgressList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getInProgressList().addTask("task in progress");

        //When
        String result = board.getInProgressList().getTask(0);

        //Then
        assertEquals("task in progress", result);
    }
    @Test
    void testTaskAddGetDoneList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("First done task");

        //When
        String result = board.getDoneList().getTask(0);

        //Then
        assertEquals("First done task", result);

    }

}
