package com.company;
import java.util.Scanner; // enable I/O
public class UltimateQuestion {

    public static void main(String[] args) {

        Scanner num= new Scanner(System.in); // input from user
        int i; // initializing i as integer

        do{ // the prompt in do to repeat until it get to while
            System.out.println("Enter a number");
            i=Integer.parseInt(num.nextLine());
        }while(i!=42);
        {
            System.out.println("That's the number I was looking for! 42 is definitely the answer!");
        }

    }
}
