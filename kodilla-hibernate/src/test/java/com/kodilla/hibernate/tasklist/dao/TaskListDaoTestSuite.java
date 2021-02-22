package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Find your Way";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Lewandowski", DESCRIPTION);
        //When
        taskListDao.save(taskList);
        String lastName = taskList.getLastName();
        //Then
        List<TaskList> readTaskList = taskListDao.findByLastName(lastName);
        assertEquals(1,readTaskList.size());
        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);



    }
}
