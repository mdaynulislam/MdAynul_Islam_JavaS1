package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = Integer.parseInt(in.nextLine());
        if(num%2==0){

            System.out.println("This is an Even number");
        }else{

            System.out.println("This is a Odd number");
        }
    }
}
