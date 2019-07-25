package com.company;

import java.util.Scanner; // enable I/O

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);// taking input
        System.out.println("Enter a number");
        int num = Integer.parseInt(in.nextLine());// converting into integer
        if(num%2==0){ //checking whether the input is divisible by 2 or not

            System.out.println("This is an Even number");
        }else{

            System.out.println("This is a Odd number");
        }
    }
}
