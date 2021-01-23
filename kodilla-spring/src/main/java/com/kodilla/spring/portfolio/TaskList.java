package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class TaskList {

    List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();

    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public String getTask(int index) {
        return tasks.get(index);
    }

    @Override
    public String toString() {
        return "TaskList{" + "tasks=" + tasks + '}';
    }
}
