package com.company;
import java.util.Scanner;
import java.util.Random;// enable random number input

public class ANumberGuessingGame {

    public static void main(String[] args) {

        int num=0;
        Random rand= new Random(); //random input
        for(int i=0;i<=10;i++) {
            num = 1 + rand.nextInt(10); //1+ to avoid the value 0
           // System.out.println(num); // it's a cheat just if we want to see the random number
        }
        System.out.println("I'm thinking of a number from 1 to 10. ");
        Scanner in= new Scanner(System.in);
        int guess= Integer.parseInt(in.nextLine());//taking user input
        System.out.println("Your guess is: " +guess);

        if(guess==num){  // conditional check

            System.out.println("That's right!  My secret number was " +num+"!");
        } else
        {
            System.out.println("Sorry, but I was really thinking of: "+num);
        }
    }
}
