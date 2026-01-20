package com.EduResultsRankSheetGenerator;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        District d1 = new District();
        d1.addStudent("Aayush", 92);
        d1.addStudent("Neha", 88);

        District d2 = new District();
        d2.addStudent("Rathour", 92);
        d2.addStudent("Vikram", 81);

        RankMerger rm = new RankMerger();
        ArrayList<Student> stateRank =
                rm.merge(d1.students, d2.students);

        for (Student s : stateRank) {
            System.out.println(s.name + " - " + s.score);
        }
    }
}
