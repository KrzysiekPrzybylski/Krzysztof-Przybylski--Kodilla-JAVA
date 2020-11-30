package com.kodilla.stream1.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

public class Board1 {


    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature", "Write and test the microservice taking\n" + "the temperaure from external service",
                user1, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis", "Prepare some HQL queries for analysis",
                user1, user2, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity", "Prepare entity for temperatures",
                user3, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger", "Refactor company logger to meet our needs",
                user3, user2, LocalDate.now().minusDays(10), LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching", "Archive data searching has to be optimized",
                user4, user2, LocalDate.now(), LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams", "use Streams rather than for-loops in predictions",
                user4, user2, LocalDate.now().minusDays(15), LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> taskListInProgress = new ArrayList<>();
        taskListInProgress.add(new TaskList("In progress"));

        int sumOfDays = project.getTaskLists().stream()
                .filter(taskListInProgress::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .reduce(0, (sum, current) -> sum += current);

        int testQuantity = project.getTaskLists().stream()
                .filter(taskListInProgress::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .map(n -> 1)
                .reduce(0, (sum, current) -> sum += current);

        double average = sumOfDays / (double)testQuantity;

        double average1 = project.getTaskLists().stream()
                .filter(taskListInProgress::contains)
                .flatMap(tasks -> tasks.getTasks().stream())
                .map(task -> Period.between(task.getCreated(), LocalDate.now()).getDays())
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        //Then
        assertEquals(10.00, average, 0.001);
        assertEquals(10.00, average1, 0.001);

    }
}



