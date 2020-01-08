package com.example.quizapp;

public class Question {
    private int answerResId;
    private boolean answer;

    public Question(int answerResId, boolean answer) {
        this.answerResId = answerResId;
        this.answer = answer;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
