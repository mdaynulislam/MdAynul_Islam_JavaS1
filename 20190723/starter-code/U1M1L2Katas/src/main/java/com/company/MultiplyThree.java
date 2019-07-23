package com.company;
import java.util.Scanner; // enable I/O


public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //enable the input

        System.out.println("Please enter you first number");
        float num1 = Float.parseFloat(scanner.nextLine()); // inputting first number

        System.out.println("Please enter you second number");
        float num2 = Float.parseFloat(scanner.nextLine()); // inputting second number

        System.out.println("Please enter you third number");
        float num3 = Float.parseFloat(scanner.nextLine()); // inputting third number

        System.out.printf("The Multiplication is %f", (num1 * num2 * num3));  // printing the first string with %f then multiplying all three numbers
    }
}