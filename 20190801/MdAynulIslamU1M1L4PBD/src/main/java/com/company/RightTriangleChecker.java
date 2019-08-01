package com.company;
import java.util.Scanner; // enable I/O
public class RightTriangleChecker {

    public static void main(String[] args) {

        int num1;
        int num2;
        int num3;
        System.out.println("Enter Three integers in ascending order-\t");

        Scanner sc=new Scanner(System.in);
        System.out.println("Side 1: ");
         num1=Integer.parseInt(sc.nextLine());


        do{
            System.out.println("Side 2 ");
             num2=Integer.parseInt(sc.nextLine());
            if(num1>num2)

                System.out.println("Side 1: " + num1 + "\n" +
                        "Side 2: " + num2 + "\n" +
                        "Side 2: " + num2 + " is smaller than Side 1: " + num1 + " Try again.");
        }while (num1>num2);
            do{
                System.out.println("Side 3 ");
                num3=Integer.parseInt(sc.nextLine());

                if(num2>num3)
                    System.out.println("Side 1: " +num1+ "\n" +
                            "Side 2: " +num2+ "\n" +
                            "Side 3: " +num3+ "\n" +
                            "Side 3: " +num3+ " is smaller than Side 2: " +num1+  " Try again.");

            } while (num2>num3);


        System.out.println("Your three sides are " +num1+ " , " +num2+" , "   +num3);
        System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
    }

}

