package com.company;
import java.util.Scanner;
public class RangeChecker {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("Please enter a number between 15 and 32 ");
            num = Integer.parseInt(scanner.next());
        } while (num <= 15 || num >= 32);
        {
            System.out.println("Your number is "+num);
        }
    }
}


