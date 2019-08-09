package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValue {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 10) { // defining the size
            Random rand = new Random();
            Integer num = 1 + rand.nextInt(100);
            numbers.add(num); // populating the array
        }
        System.out.println(numbers);

        int highest=numbers.get(0);

        for(int i=0; i<numbers.size();i++){

            if(numbers.get(i)>highest){

                highest=numbers.get(i);
            }
        }
        System.out.println(highest+ " is the highest number in the ArrayList");

    }
}
