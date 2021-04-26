package kodillapatterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties;

class HomeworkTaskQueueTestSuite {

    @Test
    void testAddTask(){
        //Given
        Student krzysiek = new Student("Krzysiek");
        Student tomek = new Student("Tomek");
        Student ewa = new Student("Ewa");
        Student kasia = new Student("Kasia");
        Student ania = new Student("Ania");
        Mentor java = new Mentor("Robert");
        Mentor javaScript = new Mentor("Rafał");
        HomeworkTaskQueue javaKrzysiek = new HomeworkTaskQueue("Java", krzysiek);
        HomeworkTaskQueue javaTomek = new HomeworkTaskQueue("Java", tomek);
        HomeworkTaskQueue javaScriptKasia = new HomeworkTaskQueue("JavaScript", kasia);
        HomeworkTaskQueue javaScriptAnia = new HomeworkTaskQueue("JavaScript", ania);
        HomeworkTaskQueue javaScriptEwa = new HomeworkTaskQueue("JavaScript", ewa);
            javaKrzysiek.registerObserver(java);
            javaTomek.registerObserver(java);
            javaScriptEwa.registerObserver(javaScript);
            javaScriptAnia.registerObserver(javaScript);
            javaScriptKasia.registerObserver(javaScript);
            //When
            javaKrzysiek.addTask("task1");
            javaKrzysiek.addTask("task2");
            javaTomek.addTask("task1");
            javaTomek.addTask("task3");

            javaScriptEwa.addTask("task4");
            javaScriptAnia.addTask("task5");
            javaScriptKasia.addTask("task6");
            //Then
            Assertions.assertEquals(4, java.getUpdateCount());
            Assertions.assertEquals(3, javaScript.getUpdateCount());
        }

}