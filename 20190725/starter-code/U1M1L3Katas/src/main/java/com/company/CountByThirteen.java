package com.company;

import java.util.Scanner; // enable I/O

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//taking input
        System.out.println("Enter a number");
        int num = Integer.parseInt(in.nextLine()); // converting the input into integer
        for (int i = 0; i <= num; i = i + 13) { // in a for loop incrementing i with 13 counts
            System.out.println(i);

        }
    }
}