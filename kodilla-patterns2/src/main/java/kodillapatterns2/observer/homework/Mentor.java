package kodillapatterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer{
    private final String name;
    private final List<Student> students = new ArrayList<>();
    private int updateCount = 0;

    public Mentor(String name) {
        this.name = name;
    }
    @Override
    public void update(HomeworkTaskQueue homeworkTaskQueue) {
        System.out.println(this.getName() + ", your student " + homeworkTaskQueue.getStudent().getName()
                + " on course " + homeworkTaskQueue.getCourse() + " has sent a new task:" +
                homeworkTaskQueue.getTasks());
        updateCount++;
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
    public String getName() {
        return name;
    }
    public int getUpdateCount() {
        return updateCount;
    }
}
