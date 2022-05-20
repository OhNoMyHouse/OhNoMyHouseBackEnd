package com.ssafy.happyhouse.model.dto;

public class QnA {
    int idx;
    String question;
    String answer;

    public QnA() {
        super();
    }

    public QnA(int idx, String question, String answer) {
        this.idx = idx;
        this.question = question;
        this.answer = answer;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
