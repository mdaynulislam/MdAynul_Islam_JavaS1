package com.company;
import java.util.Scanner; // enable I/O

public class DoubleAndAddFive {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter your number:");
        int num1 = Integer.parseInt(scanner.nextLine()); // taking input
        int sum = num1*2;

        System.out.println("The Total is"+(sum+5)); //printing the result

    }
}
