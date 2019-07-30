package com.company;
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingWithACounter {

    public static void main(String[] args) {
        int count=1;
        Random rand= new Random();
        int num=1+rand.nextInt(10);
        //System.out.println("Random #"+num);
        System.out.println("I'm thinking of a number between 1-10. Try to guess ");
        Scanner in =new Scanner(System.in);
        int guess=Integer.parseInt(in.nextLine());
        System.out.println("Your guess: "+guess);

        while (guess!=num){
            System.out.println("That is incorrect.  Guess again. ");
             guess=Integer.parseInt(in.nextLine());
            System.out.println("Your guess: "+guess);
            count++;
        }
        System.out.println("That's right!  You're a good guesser.\n" +
                "It only took you "+count+ " tries.");
    }
}
