package com.EduMentorPersonalizedLearningPlatform;

public class Quiz {
    private String[] questions;
    private int[] answers;
    private int score;

    Quiz(String[] questions, int[] answers) {
        this.questions = questions;
        this.answers = answers;
        this.score = 0;
    }

    void submitQuiz(int[] userAnswers) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == userAnswers[i]) {
                score = score + 1;
            }
        }
    }

    double calculatePercentage() {
        return (score * 100.0) / answers.length;
    }
}
