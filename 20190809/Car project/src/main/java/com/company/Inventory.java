package com.company;

import java.util.ArrayList;
import java.util.List;

public class Inventory {


   private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car>searchByMake(String make){
        List<Car> carsThatMatch=new ArrayList<>();

        cars.stream().filter(mk-> mk.getMake().equals(make)).forEach(mk -> carsThatMatch.add(mk));
        return carsThatMatch;
    }

    public List<Car>searchByModel(String model){
        List<Car> carsThatMatch=new ArrayList<>();

        cars.stream().filter(mk-> mk.getModel().equals(model)).forEach(mk -> carsThatMatch.add(mk));
        return carsThatMatch;
    }

    public List<Car>searchByColor(String color){
        List<Car> carsThatMatch=new ArrayList<>();

        cars.stream().filter(mk-> mk.getColor().equals(color)).forEach(mk -> carsThatMatch.add(mk));
        return carsThatMatch;
    }

    public List<Car>searchByYear(int year){
        List<Car> carsThatMatch=new ArrayList<>();

        cars.stream().filter(mk-> mk.getYear() >= year).forEach(mk -> carsThatMatch.add(mk));
        return carsThatMatch;
    }

    public List<Car>searchByMileage(int mileage){
        List<Car> carsThatMatch=new ArrayList<>();

        cars.stream().filter(mk-> mk.getMileage() >= mileage).forEach(mk -> carsThatMatch.add(mk));
        return carsThatMatch;
    }


    public void deleteCar(int id){

        cars.remove(id);

    }

    public void addCar(Car car){

        cars.add(car);
    }


}
