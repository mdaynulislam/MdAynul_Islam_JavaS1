package com.comapny;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class BasicArrayLists2 {
    public static void main(String[] args) {



        List<Integer> numbers=new ArrayList<>();
        while(numbers.size()<10){ // defining the size
            Random rand=new Random();
            Integer num= 1+rand.nextInt(10);
            numbers.add(num); // populating the array
        }
            System.out.println("ArrayList: " +numbers ); // printing the array in single line

    }
}
