package com.student.StudentManagementJava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world! (Java-config version)
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService service =
                context.getBean("studentService", StudentService.class);

        Student student =
                new Student(101, "Aayush", "B.Tech AIML");

        service.registerStudent(student);

    }

}
