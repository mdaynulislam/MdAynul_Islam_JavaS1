package com.company;

public class CoffeeMaker {

    private String manufacturer;
    private  String model;
    private  int carafeSize;
    private  int cupsLeft;
    private boolean running;

    public CoffeeMaker ( String newManufacturer, String newModel, int newCarafeSize, int newCupsLeft,  boolean newRunning) {

        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.carafeSize =newCarafeSize;
        this.cupsLeft = newCupsLeft;
        this.running = newRunning;

    }

    public String getManufacturer(){
        return manufacturer;

    }
    public String getModel(){
        return model;
    }
    public int getCarafeSize(){
        return carafeSize;
    }
    public int getCupsLeft(){
        return cupsLeft;
    }

    public boolean isPowered(){
        return  running;
    }
}
