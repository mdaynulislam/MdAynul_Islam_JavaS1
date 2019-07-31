package com.company;

public class Microwave {

    private String manufacturer;
    private  String model;
    private  int secondsLeft;
    private String time;
    private boolean running;

    public Microwave ( String newManufacturer, String newModel, int newSecondsLeft, String newTime,  boolean newRunning) {

        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.secondsLeft =newSecondsLeft;
        this.time = newTime;
        this.running = newRunning;

    }

    public String getManufacturer(){
        return manufacturer;

    }
    public String getModel(){
        return model;
    }
    public int getSecondsLeft(){
        return secondsLeft;
    }
    public String getTime(){
        return time;
    }

    public boolean isRunning(){
        return  running;
    }
}
