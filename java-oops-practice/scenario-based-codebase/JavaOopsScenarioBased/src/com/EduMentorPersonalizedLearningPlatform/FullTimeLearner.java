package com.EduMentorPersonalizedLearningPlatform;

public class FullTimeLearner extends Learner {

    FullTimeLearner(String name, String email, int userId) {
        super(name, email, userId);
    }

    public void generateCertificate() {
        System.out.println("Certificate for Full-Time Program: " + name);
    }
}
