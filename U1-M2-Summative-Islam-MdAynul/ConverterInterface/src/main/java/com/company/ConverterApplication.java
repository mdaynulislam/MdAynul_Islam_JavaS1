package com.company;
import java.util.Scanner;

public class ConverterApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConverterIf convert1 = new ConverterIf();
        ConverterSwitch convert2 = new ConverterSwitch();

        System.out.println("Please Enter a number to get the name of the month");
        int userInput = sc.nextInt();
        System.out.println(userInput + " is " + convert1.convertMonth(userInput));
        System.out.println("");
        System.out.println("");


        System.out.println("Please Enter a number to get the name of the day");
        userInput = sc.nextInt();
        System.out.println(userInput + " is " + convert1.convertDay(userInput));
        System.out.println("");
        System.out.println("");

        System.out.println("Please Enter a number to get the name of the month");
        int userInput1 = sc.nextInt();
        System.out.println(userInput1 + " is " + convert2.convertMonth(userInput1));
        System.out.println("");
        System.out.println("");

        System.out.println("Please Enter a number to get the name of the day");
        userInput1 = sc.nextInt();
        System.out.println(userInput1 + " is " + convert2.convertDay(userInput1));



    }
}
