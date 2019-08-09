package com.company;

public class POSIceCreamShop {


    private String name;
    private int price;
    private int varietyInStock;
    private int numOfItemDelivered;
    private int numOfFlavor;
    private boolean driveThrough;


    public POSIceCreamShop(String name, int price, int varietyInStock, int numOfItemDelivered, int numOfFlavor, boolean driveThrough)

                 {
                this.name = name;
                this.price = price;
                this.varietyInStock = varietyInStock;
                this.numOfItemDelivered = numOfItemDelivered;
                this.numOfFlavor=numOfFlavor;
                this.driveThrough=driveThrough;
                }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getVarietyInStock() {
                return varietyInStock;
            }

            public void setVarietyInStock(int varietyInStock) {
                this.varietyInStock = varietyInStock;
            }

            public int getNumOfItemDelivered() {
                return numOfItemDelivered;
            }

            public void setNumOfItemDelivered(int numOfItemDelivered) {
                this.numOfItemDelivered = numOfItemDelivered;
            }

            public int getNumOfFlavor() {
                return numOfFlavor;
            }

            public void setNumOfFlavor(int numOfFlavor) {
                this.numOfFlavor = numOfFlavor;
            }

            public boolean isDriveThrough() {
                return driveThrough;
            }

            public void setDriveThrough(boolean driveThrough) {
                this.driveThrough = driveThrough;
            }
}
