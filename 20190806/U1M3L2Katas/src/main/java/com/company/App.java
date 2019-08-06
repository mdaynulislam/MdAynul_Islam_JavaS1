package com.company;

import java.util.*;

public class App {



    public void printKeys(Map<String, String>map1 ) {

        System.out.println(map1.size());

        Set<String> myKeys = map1.keySet();
        for (String key : myKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> map1) {

        System.out.println(map1.size());

        Collection<String> myValues = map1.values();
        for (String value : myValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> map1) {

        map1.entrySet().forEach(entry-> {
            System.out.println(entry.getKey() +": "+ entry.getValue());
        });
    }

    public static Map<String, Integer> mapFun(Map<String, Integer> map2) {


        map2.put("Ford Explorer", 2012);
        map2.put("Smart Fortwo", 2013);

        map2.remove("Jeep Wrangler", 2003);
        return map2;
    }

    public Map<String, List<Car>> listCars(List<Car> cars) {
        Map<String, List<Car>> map = new HashMap<>();

        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        map.put("Toyota", toyotaList);
        map.put("Honda", hondaList);
        map.put("Ford", fordList);

        for (Car car : cars) {
            if (car.make == "Toyota") {
                toyotaList.add(car);
            }
        }

        for (Car car : cars) {
            if (car.make == "Ford") {
                fordList.add(car);
            }
        }

        for (Car car : cars) {
            if (car.make == "Honda") {
                hondaList.add(car);
            }
        }
        return map;
    }


}
