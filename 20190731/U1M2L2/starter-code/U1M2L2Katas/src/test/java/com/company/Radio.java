package com.company;

public class Radio {

    private String manufacturer;
    private  String model;
    private  int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio ( String newManufacturer, String newModel, int newSpeakers, String newStation, int newVolume, boolean newPowered) {

        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.numSpeakers = newSpeakers;
        this.station = newStation;
        this.volume = newVolume;
        this.powered = newPowered;

    }


    public void togglePower(){

    }
    public String getManufacturer(){
        return manufacturer;

    }
    public String getModel(){
        return model;
    }
    public int getNumSpeakers(){
        return numSpeakers;
    }
    public String getStation(){
        return station;
    }
    public int getVolume(){
        return  volume;
    }
    public boolean isPowered(){
        return  powered;
    }





}
