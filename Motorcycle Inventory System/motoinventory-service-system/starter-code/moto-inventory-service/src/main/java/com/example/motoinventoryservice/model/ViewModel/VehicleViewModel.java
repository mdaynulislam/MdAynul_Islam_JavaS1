package com.example.motoinventoryservice.model.ViewModel;

import java.util.Objects;

public class VehicleViewModel {

    private String type;
    private  String make;
    private  String model;
    private  String year;
    private  String color;

    //getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Equal and Hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleViewModel that = (VehicleViewModel) o;
        return type.equals(that.type) &&
                make.equals(that.make) &&
                model.equals(that.model) &&
                year.equals(that.year) &&
                color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, make, model, year, color);
    }
}
