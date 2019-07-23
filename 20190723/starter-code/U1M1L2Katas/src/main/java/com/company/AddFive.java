package com.company;
import java.util.Scanner; // enable I/O

public class AddFive {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Please enter you first number");
        float num1 = Float.parseFloat(scanner.nextLine()); // inputting first number

        System.out.println("Please enter you second number");
        float num2 = Float.parseFloat(scanner.nextLine()); // inputting second number

        System.out.println("Please enter you third number");
        float num3 = Float.parseFloat(scanner.nextLine()); // inputting third number

        System.out.println("Please enter you fourth number");
        float num4 = Float.parseFloat(scanner.nextLine()); // inputting fourth number

        System.out.println("Please enter you fifth number");
        float num5 = Float.parseFloat(scanner.nextLine()); // inputting fifth number

        System.out.printf("The Total is %f", (num1 + num2 + num3 + num4 + num5));  // printing the first string with %f then adding all five numbers
    }
}
