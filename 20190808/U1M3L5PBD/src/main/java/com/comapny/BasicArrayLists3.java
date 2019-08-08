package com.comapny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();

        while(numbers.size()<1000){ // defining the size
            Random rand=new Random();
            Integer num= rand.nextInt(90)+10;
            numbers.add(num); // populating the array
        }
        System.out.println(numbers);
    }
}
