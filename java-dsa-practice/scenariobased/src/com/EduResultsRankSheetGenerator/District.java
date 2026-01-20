package com.EduResultsRankSheetGenerator;


import java.util.*;

class District {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(String name, int score) {
        students.add(new Student(name, score));
    }
}
