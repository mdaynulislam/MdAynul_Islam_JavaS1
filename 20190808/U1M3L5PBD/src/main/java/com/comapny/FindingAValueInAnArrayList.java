package com.comapny;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArrayList {

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


        for (int num : numbers) {
            if (num == userInput) {
                System.out.println(userInput + " is in the ArrayList");
            }
        }
    }
}