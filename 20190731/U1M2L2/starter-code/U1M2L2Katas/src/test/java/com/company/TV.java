package com.company;

public class TV {

    private String manufacturer;
    private  String model;
    private  int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public TV ( String newManufacturer, String newModel, int newScreenSize, String newChannel, int newVolume, boolean newPowered) {

        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.screenSize =newScreenSize;
        this.channel = newChannel;
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
    public int getScreenSize(){
        return screenSize;
    }
    public String getChannel(){
        return channel;
    }
    public int getVolume(){
        return  volume;
    }
    public boolean isPowered(){
        return  powered;
    }

}
