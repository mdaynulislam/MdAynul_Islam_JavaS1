package com.company;
import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {

        System.out.println("SQUARE ROOT:");
        System.out.println("Enter a number ");

        Scanner sc =new Scanner(System.in);
        int i =Integer.parseInt(sc.nextLine());  //user input
        double sq=Math.sqrt(i); //Math.sqrt for square root

        while(i<1){ // for negative values input by user
            System.out.println("You can't take the square root of a negative number, silly. ");
            System.out.println("Try again ");
            i =Integer.parseInt(sc.nextLine());
             sq=Math.sqrt(i);
        }
        System.out.println("The square of "+i+ " is "+sq);

    }
}
