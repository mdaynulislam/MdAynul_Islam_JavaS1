package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = Integer.parseInt(in.nextLine());
        for (int i = 0; i <= num; i = i + 13) {
            System.out.println(i);

        }
    }
}