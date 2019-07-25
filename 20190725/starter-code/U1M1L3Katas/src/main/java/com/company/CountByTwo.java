package com.company;

import java.util.Scanner; // enable I/O

public class CountByTwo {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in); // taking input from user
        System.out.println("Enter a number");
        int num=Integer.parseInt(in.nextLine()); // converting into integer
        for(int i=0; i<=num; i=i+2){ // incrementing by 2
            System.out.println(i);
        }

    }
}
