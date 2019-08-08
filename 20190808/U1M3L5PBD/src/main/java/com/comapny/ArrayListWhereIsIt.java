package com.comapny;

import java.util.*;

public class ArrayListWhereIsIt {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 10) { // defining the size
            Random rand = new Random();
            Integer num = 1 + rand.nextInt(50);
            numbers.add(num); // populating the array
        }
        System.out.println("ArrayList: " + numbers); // printing the array in single line
        System.out.println("Value to find:");

        Scanner sc = new Scanner(System.in);
        int userInput = Integer.parseInt(sc.nextLine());// user input

         for (int i=0;i<numbers.size();i++){
             if(numbers.get(i)==userInput){

                 System.out.println(userInput+" is in the slot " +i);
             }
         }
         if(!numbers.contains(userInput)){
             System.out.println(userInput+" The number is not in the ArrayList ");
         }
    }
}
