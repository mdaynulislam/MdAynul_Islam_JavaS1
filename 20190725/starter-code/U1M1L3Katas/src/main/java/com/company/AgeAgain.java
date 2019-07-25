package com.company;
import java.util.Scanner;
public class AgeAgain {

    public static void main(String[] args) {

        String job;
        Scanner in=new Scanner(System.in);
        System.out.println("What is your age");
        int i =Integer.parseInt(in.nextLine());

        if(i<14){
            System.out.println("What grade you are in");
            String g=in.nextLine();
            System.out.println("Wow! " +g+  " grade - that sounds exciting!");
    }
        if(i>=14 && i<=18){
            System.out.println("Are you planning for college?");
            System.out.println("Enter yes or no");
            String yn=in.nextLine();
           if(yn.equals("yes")) {
                System.out.println("what college you are planning to go?");
                String col = in.nextLine();
                System.out.println(col + " is a great school!");

            } if(yn.equals("no")){
               System.out.println("what you want to do after high school");
               String plan=in.nextLine();
               System.out.println(plan+ "Wow, "+plan+" sounds like a plan!");
           }

        }
        if (i>18){
            System.out.println("What is your job");
            job=in.nextLine();
            System.out.printf("%s sounds like a great job!", job);
        }
    }
}
