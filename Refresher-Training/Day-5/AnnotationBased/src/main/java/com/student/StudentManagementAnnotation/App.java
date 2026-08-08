package com.student.StudentManagementAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world! (Annotation-based version)
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // bean id defaults to the class name with a lowercase first letter
        StudentService service =
                context.getBean("studentService", StudentService.class);

        Student student =
                new Student(101, "Aayush", "B.Tech AIML");

        service.registerStudent(student);

    }

}
