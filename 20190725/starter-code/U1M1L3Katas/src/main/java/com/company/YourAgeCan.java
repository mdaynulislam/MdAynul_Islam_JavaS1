package com.company;
import java.util.Scanner; // enable I/O
public class YourAgeCan {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = in.nextInt(); // initialize input to integer


        if (age >= 18) { // putting all the condition in if to print all that apply except for >100
            System.out.println("Your can Vote");

            if (age >= 21) {
                System.out.println("Your can Drink alcohol");

                if (age >= 35) {
                    System.out.println("Your can Be a president");

                    if (age >= 55) {
                        System.out.println("Your are eligible for AARP");

                        if (age >= 65) {
                            System.out.println("Your can retire");

                            if (age >= 80 && age <= 89) {

                                System.out.println("Your can be an Octogenarian");

                            }
                        }
                    }
                }
            }
        }
        if (age >= 100) {

            System.out.println("Your are a century old");
        }
    }
}


