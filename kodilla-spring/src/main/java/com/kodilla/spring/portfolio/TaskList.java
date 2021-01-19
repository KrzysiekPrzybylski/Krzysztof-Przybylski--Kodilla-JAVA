package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class TaskList {

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
