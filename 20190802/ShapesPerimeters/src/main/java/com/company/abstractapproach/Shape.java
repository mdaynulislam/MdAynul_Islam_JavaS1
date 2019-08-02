package com.company.abstractapproach;

public abstract class Shape {

    private String name;
    private String color;
    private double xCoOrdinate;
    private double yCoOrdinate;
    public double area(){
        return 0;
    }
    public double perimeter(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getxCoOrdinate() {
        return xCoOrdinate;
    }

    public void setxCoOrdinate(double xCoOrdinate) {
        this.xCoOrdinate = xCoOrdinate;
    }

    public double getyCoOrdinate() {
        return yCoOrdinate;
    }

    public void setyCoOrdinate(double yCoOrdinate) {
        this.yCoOrdinate = yCoOrdinate;
    }
}
