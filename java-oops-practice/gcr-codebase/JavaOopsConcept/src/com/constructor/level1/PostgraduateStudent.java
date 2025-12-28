package com.constructor.level1;

public class PostgraduateStudent extends Student {

    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public static void main(String[] args) {
        PostgraduateStudent student1 =
                new PostgraduateStudent(1, "Student 1", 8.5);

        System.out.println(student1.name);
    }
}
