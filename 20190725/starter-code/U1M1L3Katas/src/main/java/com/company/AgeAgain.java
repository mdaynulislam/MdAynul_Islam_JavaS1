package com.company;
import java.util.Scanner; //enable I/O
public class AgeAgain {

    public static void main(String[] args) {

        String job;
        Scanner in=new Scanner(System.in); // Input from user
        System.out.println("What is your age");
        int i =Integer.parseInt(in.nextLine()); //converting to integer

        if(i<14){           //first condition check
            System.out.println("What grade you are in");
            String g=in.nextLine(); //calling the nextLine to take String input
            System.out.println("Wow! " +g+  " grade - that sounds exciting!");
    }
        if(i>=14 && i<=18){  //2nd condition check with logical operator
            System.out.println("Are you planning for college?");
            System.out.println("Enter yes or no");
            String yn=in.nextLine(); // yes/no input from user
           if(yn.equals("yes")) { //comparing the input with .equals
                System.out.println("what college you are planning to go?");
                String col = in.nextLine(); // college name input from user
                System.out.println(col + " is a great school!");

            } if(yn.equals("no")){ //comparing the input with .equals
               System.out.println("what you want to do after high school");
               String plan=in.nextLine(); //after school plan input from user
               System.out.println("Wow, "+plan+" sounds like a plan!");
           }

        }
        if (i>18){ // putting this if out of the previous because it for all the age>18 and only job question
            System.out.println("What is your job");
            job=in.nextLine(); // user's job input
            System.out.printf("%s sounds like a great job!", job); // just trying different printing method with printf with %s
        }
    }
}
