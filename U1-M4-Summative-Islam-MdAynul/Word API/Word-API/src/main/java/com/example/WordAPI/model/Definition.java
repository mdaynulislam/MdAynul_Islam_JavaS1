package com.example.WordAPI.model;

public class Definition {

    private String word;
    private String definition;

    public Definition(){ // No argument constructor because Spring look for it

    }

    //parameterized constructor
    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    //getters and setters

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
