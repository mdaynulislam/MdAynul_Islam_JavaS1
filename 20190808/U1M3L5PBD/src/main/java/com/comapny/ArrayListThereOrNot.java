package com.comapny;

import java.util.*;

public class ArrayListThereOrNot {
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


        Collections.sort(numbers);//sorting array from small to large
        int x=numbers.indexOf(userInput);//find index of beginning
        int y=numbers.lastIndexOf(userInput);//find last index of val
        int xy=y-x;

        if(numbers.contains(userInput))
        {
            for(int i=0;i<=xy;i++)
            {
                System.out.println(userInput+" is in the ArrayList");
            }
        }
        else
        {
            System.out.println(userInput+" is not in the ArrayList");
        }

    }
}
