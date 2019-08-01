package com.company;
import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {
        int i;
        System.out.println("Enter a number between 1 and 10 ");
        Scanner in=new Scanner(System.in);//user input
        i=Integer.parseInt(in.nextLine());


        while ((i < 1) || (i > 10)){ // condition if wrong number entered
            System.out.println("You must enter a number between 1 and 10, Please try again ");
            i = Integer.parseInt(in.nextLine());
        }
        if((i>=1) && (i<=10)){  // condition for the right number
            System.out.println("The number is "+i);
        }
    }
}
