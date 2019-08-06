package com.company;

import java.util.*;

public class City {


    public String name;

    public int population;


    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {

        return population;
    }

    public void setPopulation(int population) {

        this.population = population;
    }

    public static void main(String[] args) {

        City ct1 = new City("New York", 2716520);

        ct1.setName("New York");

        ct1.setPopulation(2716520);

        City ct2 = new City("Los Angelos", 4563218);

        ct2.setName("Los Angelos");

        ct2.setPopulation(4563218);

        City ct3 = new City("Chicago", 2716520);

        ct3.setName("Chicago");

        ct3.setPopulation(2716520);

        City ct4 = new City("Denver", 704621);

        ct4.setName("Denver");

        ct4.setPopulation(704621);

        City ct5 = new City("Des Moines", 217521);

        ct5.setName("Des Moines");

        ct5.setPopulation(217521);

        City ct6 = new City("Atlanta", 486213);

        ct6.setName("Atlanta");

        ct6.setPopulation(486213);

        System.out.println(ct1.getName() + ct1.getPopulation());

        System.out.println(ct2.getName() + ct2.getPopulation());

        System.out.println(ct3.getName() + ct3.getPopulation());

        System.out.println(ct4.getName() + ct4.getPopulation());

        System.out.println(ct5.getName() + ct5.getPopulation());

        System.out.println(ct6.getName() + ct6.getPopulation());

        Map<String, City> map = new HashMap<>();
        map.put("New York", ct1);

        map.put("California", ct2);

        map.put("Illinois", ct3);

        map.put("Colorado", ct4);

        map.put("Iowa", ct5);

        map.put("Georgia", ct6);

        Set<Map.Entry<String, City>> myCities = map.entrySet();
        Iterator<Map.Entry<String, City>> cityIterator = myCities.iterator();

        while (cityIterator.hasNext()) {

            Map.Entry tempEntry = cityIterator.next();

            System.out.println(tempEntry.getKey());

            City ty = (City) tempEntry.getValue();

            System.out.println(" " + ty.getName() + " " + ty.getPopulation());
        }
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a number of associated state:");

        int num = Integer.parseInt(in.nextLine());

        if (num < ct1.population) {

            System.out.println(ct1.name);
        } else if (num < ct2.population) {

            System.out.println(ct2.name);
        } else if (num < ct3.population) {

            System.out.println(ct3.name);
        } else if (num < ct4.population) {

            System.out.println(ct4.name);
        } else if (num < ct5.population) {

            System.out.println(ct5.name);
        } else if (num < ct6.population) {

            System.out.println(ct6.name);
        }

    }
}