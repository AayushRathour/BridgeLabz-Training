package com.OnlineExamReviewSystem;

import java.util.*;

public class Exam{

    Stack<Integer> navigation = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();
    HashMap<Integer, String> correct = new HashMap<>();

    Exam() {
        correct.put(1, "A");
        correct.put(2, "B");
        correct.put(3, "C");
    }

    void visitQuestion(int qid) {
        navigation.push(qid);
    }

    void submitAnswer(int qid, String ans) {
        answers.put(qid, ans);
    }

    int calculateScore() {
        int score = 0;
        for (int qid : correct.keySet()) {
            if (answers.containsKey(qid)) {
                if (answers.get(qid).equals(correct.get(qid))) {
                    score++;
                }
            }
        }
        return score;
    }

    void lastVisited() {
        if (navigation.isEmpty()) {
            System.out.println("No navigation found");
        } else {
            System.out.println("Last visited question: " + navigation.peek());
        }
    }
}