package com.OnlineExamReviewSystem;

public class MainClass {
    public static void main(String[] args) {

        Exam exam = new Exam();

        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "C");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "C");

        exam.lastVisited();

        int score = exam.calculateScore();
        System.out.println("Final Score: " + score);
    }
 
}    