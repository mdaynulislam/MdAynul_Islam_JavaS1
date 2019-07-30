package com.company;
import java.util.Scanner; //enable I/O
import java.util.Random; // enable random number

public class HiLowLimitedTries {

    public static void main(String[] args) {

        int count=1;
        Random rand= new Random();
        int num=1+rand.nextInt(100);// setting the bound 1-100
       // System.out.println("Random #"+num);  // cheat check the random number.
        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses. ");

        Scanner in=new Scanner(System.in);
        int guess=Integer.parseInt(in.nextLine()); //user input
        System.out.println("First guess: "+guess);

        while ((guess!=num) && (count<7)){
            if(guess>num) {
                System.out.println("Sorry, that guess is too high. Try again");
                guess=Integer.parseInt(in.nextLine());
            } else if(guess<num){
                System.out.println("Sorry, you are too low. ");
                guess=Integer.parseInt(in.nextLine());
                  }
               count++; // increment the count
        }
           if(guess==num){ // checking for right guess
               System.out.println("You guessed it!  What are the odds?!?");
               System.out.println("You guessed it in " +count+ " tries"); // printing number of tries
           }else {
               System.out.println("Sorry, you didn't guess it in 7 tries.  You lose."); // after the 7 try and wrong number.
            }

    }

}




