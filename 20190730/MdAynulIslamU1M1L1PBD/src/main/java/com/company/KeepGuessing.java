package com.company;
import java.util.Random;// random number
import java.util.Scanner;// enable user input

public class KeepGuessing {

    public static void main(String[] args) {
         Random rand=new Random();
         int num=1+rand.nextInt(10);// taking the random number in num variable
        System.out.println("num: "+num);
        System.out.println("I have chosen a number between 1 and 10. Try to guess it. ");
        Scanner in=new Scanner(System.in);
        int guess=Integer.parseInt(in.nextLine()); // user input
        while (guess!=num){ //if its true then will print the curly braces
            System.out.println("That is incorrect. Guess again. ");
            Scanner ln=new Scanner(System.in); // putting the scanner again in the while loop so that ig the user input is wrong it will prompt for another number
             guess=Integer.parseInt(ln.nextLine());
        }
        System.out.println("That's right! You're a good guesser.");



    }
}
