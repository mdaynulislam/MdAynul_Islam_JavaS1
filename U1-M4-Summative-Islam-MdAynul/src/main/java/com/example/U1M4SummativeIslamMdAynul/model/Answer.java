package com.example.U1M4SummativeIslamMdAynul.model;

public class Answer {

    private String question;
    private String answer;

    public Answer(){   // no argument constructor for the question
    }


    public Answer(String question, String answer) { // parameterized constructor
        this.question = question;
        this.answer = answer;
    }

    //getters and setters

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
