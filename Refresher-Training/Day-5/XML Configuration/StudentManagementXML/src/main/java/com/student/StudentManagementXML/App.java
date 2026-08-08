package com.student.StudentManagementXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService service =
                context.getBean("studentService", StudentService.class);

        Student student =
                new Student(101, "Aayush", "B.Tech AIML");

        service.registerStudent(student);

    }

}
