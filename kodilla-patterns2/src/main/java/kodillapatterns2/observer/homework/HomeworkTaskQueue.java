package kodillapatterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkTaskQueue implements Observable{

    private final String course;
    private final Student student;
    private final List<String> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public HomeworkTaskQueue(String course, Student student) {
        this.course = course;
        this.student = student;
    }
    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }
    public String getCourse() {
        return course;
    }
    public Student getStudent() {
        return student;
    }
    public List<String> getTasks() {
        return tasks;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void notifyObservers() {
        observers.forEach(receiver -> receiver.update(this));
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}