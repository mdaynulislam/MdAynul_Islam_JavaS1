package com.company;
import java.util.Scanner; // enable I/O

public class SubtractTwo {

    public static void main(String[] args)

    {
        Scanner scanner = new Scanner(System.in); //enable the input

        System.out.println("Please enter you first number");
        int num1 = Integer.parseInt(scanner.nextLine()); // inputting first number

        System.out.println("Please enter you second number");
        int num2 = Integer.parseInt(scanner.nextLine()); // inputting second number

        int sub = num1-num2;

        System.out.println("The Subtraction is " + sub);  // printing the first string then doing the arithmatic operation
    }
}
