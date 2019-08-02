package com.company;

public class Home {

    private Room basement;
    private int numOfBathroom;
    private int numOfRoom;
    private Room furnishedKitchen;
    private Room attic;


    public Room getBasement() {
        return basement;
    }

    public void setBasement(Room basement) {
        this.basement = basement;
    }

    public int getNumOfBathroom() {
        return numOfBathroom;
    }

    public void setNumOfBathroom(int numOfBathroom) {
        this.numOfBathroom = numOfBathroom;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public Room getFurnishedKitchen() {
        return furnishedKitchen;
    }

    public void setFurnishedKitchen(Room furnishedKitchen) {
        this.furnishedKitchen = furnishedKitchen;
    }

    public Room getAttic() {
        return attic;
    }

    public void setAttic(Room attic) {
        this.attic = attic;
    }

    public void setSquareFoot(int sq){

    }
    public void setFlooringType(String ft){

    }

}
