package com.EduMentorPersonalizedLearningPlatform;

public class MainClass {
    public static void main(String[] args) {

        Learner learner1 = new Learner("Aayush", "a@gmail.com", 101);
        Learner learner2 = new FullTimeLearner("Rathour", "r@gmail.com", 102);

        String[] questions = {"Q1", "Q2", "Q3"};
        int[] answers = {1, 2, 3};

        Quiz quiz = new Quiz(questions, answers);
        int[] userAnswers = {1, 2, 2};

        quiz.submitQuiz(userAnswers);

        System.out.println("Score Percentage: " + quiz.calculatePercentage());

        learner1.generateCertificate();
        learner2.generateCertificate();
    }
}
