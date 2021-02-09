package com.kodilla.patterns.factory.task;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    public void testMakeShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING,
                "My shopping list",
                "potatoes",
                "2.5");
        boolean beforeExecution = shopping.isTaskExecuted();
        shopping.executeTask();
        //Then
        assertEquals("My shopping list", shopping.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testMakePaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(TaskFactory.PAINTING,
                "My painting task", "blue", "my car");
        boolean beforeExecution = painting.isTaskExecuted();
        painting.executeTask();
        //Then
        assertEquals("My painting task", painting.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testMakeDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(TaskFactory.DRIVING,
                "My driving task", "to heaven", "my painted blue car");
        boolean beforeExecution = driving.isTaskExecuted();
        driving.executeTask();
        //Then
        assertEquals("My driving task", driving.getTaskName());
        assertFalse(beforeExecution);
        assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testNullTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task nullTask = taskFactory.makeTask("Null",
                "My null task", "", "");
        //Then
        assertNull(nullTask);
    }
}
