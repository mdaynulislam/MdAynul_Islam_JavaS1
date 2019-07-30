package com.company;
import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        String opinion;
        int count=0;

        System.out.println("Are you ready for a quiz?");
        Scanner str=new Scanner(System.in);
        opinion=str.nextLine();
        if (opinion.equals("y")) {
            System.out.println("Okay, here it comes!");
            System.out.println("Q1) What is the capital of Alaska?\n" +
                    "\t1) Melbourne\n" +
                    "\t2) Anchorage\n" +
                    "\t3) Juneau");
            System.out.println("Enter the numbers corresponding your answer: ");
            Scanner p=new Scanner(System.in);
            int q1=Integer.parseInt(p.nextLine());
            if(q1==3){
                System.out.println("That's right!");
                count++;
            } else {
                System.out.println("It's actually Juneau..");
              }
               System.out.println("Try the next one..");

                System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?\n" +
                    "\t1) yes\n" +
                    "\t2) no");
            Scanner q=new Scanner(System.in);
            int q2=Integer.parseInt(q.nextLine());
            if(q2==2){
                System.out.println("That's right!");
                count++;
            } else {
                System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
              }
            System.out.println("Try the next one..");
            System.out.println("Q3) What is the result of 9+6/3?\n" +
                    "\t1) 5\n" +
                    "\t2) 11\n" +
                    "\t3) 15/3");
            Scanner m=new Scanner(System.in);
            int q3=Integer.parseInt(m.nextLine());
            if(q3==2){
                System.out.println("That's right!");
                count++;
            } else {
                System.out.println("It's actually 5 ");
              }

              System.out.println("Overall, you got "+count+ " out of 3 correct.\n" +
                    "Thanks for playing!");
        }else{
            System.out.println("Hope you will try next time..it's really fun");
          }

    }
}
