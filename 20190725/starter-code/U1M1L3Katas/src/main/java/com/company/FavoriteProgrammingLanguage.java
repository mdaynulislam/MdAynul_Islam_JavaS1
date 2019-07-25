package com.company;
import java.util.Scanner; // enable I/O

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in); // input from user
        String str; // put in str


        do { // using do to repeat the process until it goes to while & print the same prompt
            System.out.println("What is your favorite programming Language");
             str=in.nextLine();
        }

        while(!str.equals("Java")); // while this is false it will execute the final output
        {
            System.out.println("That's what I was looking for! Java is definitely the answer!");
        }


    }
}
