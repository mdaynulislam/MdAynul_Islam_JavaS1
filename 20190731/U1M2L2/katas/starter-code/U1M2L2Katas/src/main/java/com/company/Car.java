package com.company;

public class Car {

    private String manufacturer;
    private  String model;
    private  String type;
    private  String color;
    private  String engine;
    private  String transmission;
    private  int numDoors;
    private  double mpg;
    private int mileDriven;

    public Car ( String newMake, String newModel,String newType, String newColor,String newEngine, String newTransmission, int newNumDoors, double newMpg,  int newMileDriven) {

        this.manufacturer = newMake;
        this.model = newModel;
        this.type=newType;
        this.color=newColor;
        this.engine=newEngine;
        this.transmission=newTransmission;
        this.numDoors=newNumDoors;
        this.mpg=newMpg;
        this.mileDriven=newMileDriven;
    }

    public String getMake(){
        return manufacturer;

    }
    public String getModel(){
        return model;
    }
    public String getType(){
        return type;
    }
    public String getColor(){
        return color;

    }
    public String getEngine(){
        return engine;
    }
    public String getTransmission(){
        return transmission;
    }
    public int getNumDoors(){
        return numDoors;
    }
    public double getMpg(){
        return mpg;
    }

    public int getMilesDriven(){
        return  mileDriven;
    }
    public int Drive(int miles){
        return miles;
    }
    public boolean honk(){
        return true;
    }
}
