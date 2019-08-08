package com.comapny;

import java.util.*;

public class CopyingArrayLists {

    public static void main(String[] args) {


        List<Integer> numbers=new ArrayList<>();
        //List<Integer> copyArray=new ArrayList<>(10);

        while(numbers.size()<10){ // defining the size
            Random rand=new Random();
            Integer num= 1+rand.nextInt(10);
            numbers.add(num); // populating the array
        }

        List<Integer> copyArray=new ArrayList<>(numbers); // copying in a new arrayList

        numbers.set(numbers.size()-1,-7); // setting -7 in last position
        System.out.println(numbers);
       System.out.println(copyArray);

    }
}
