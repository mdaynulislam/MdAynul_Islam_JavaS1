package com.company;

public class ComputerMouse {

    private String manufacturer;
    private  String model;
    private  int xPosition;
    private  int yPosition;
    private int lastClicked[];


    public ComputerMouse ( String newManufacturer, String newModel, int newXPosition,int newYPosition,  int[] newLastClickedLocation) {

        this.manufacturer = newManufacturer;
        this.model = newModel;
        this.xPosition =newXPosition;
        this.yPosition= newYPosition;
        this.lastClicked = newLastClickedLocation;

    }

    public String getManufacturer(){
        return manufacturer;

    }
    public String getModel(){
        return model;
    }
    public int getxPosition(){
        return xPosition;
    }
    public int getyPosition(){
        return yPosition;
    }
    public int[] getLastClickedLocation (){
        return lastClicked;
    }
    public int move(int deltaX, int deltaY){
        return deltaX;

    }

}
