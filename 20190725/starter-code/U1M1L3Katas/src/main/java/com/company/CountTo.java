package com.company;
import java.util.Scanner; // enable I/O
public class CountTo {

    public static void main(String[] args) {

        Scanner in= new Scanner(System.in); // taking input
        System.out.println("Enter a number");
        int num=Integer.parseInt(in.nextLine()); // converting into integer
         for(int i=0; i<=num; i++){ // incrementing by 1
             System.out.println(i);
         }

    }
}
