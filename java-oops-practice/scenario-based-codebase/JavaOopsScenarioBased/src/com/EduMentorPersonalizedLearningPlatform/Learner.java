package com.EduMentorPersonalizedLearningPlatform;

public class Learner extends User implements Certifiable {

    Learner(String name, String email, int userId) {
        super(name, email, userId);
    }

    public void generateCertificate() {
        System.out.println("Certificate for Short Course Learner: " + name);
    }
}
