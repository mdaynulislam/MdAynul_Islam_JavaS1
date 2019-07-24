package com.company;
import java.util.Scanner; // enable I/O
public class AddThirteen

{

    public static void main(String[] args)

    {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter your number:");
        float num1 = Float.parseFloat(scanner.nextLine()); // taking input



        System.out.println("The Total is"+(num1+13)); //printing thr result




    }
}
