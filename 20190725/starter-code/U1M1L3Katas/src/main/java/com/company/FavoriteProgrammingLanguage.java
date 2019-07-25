package com.company;
import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String str;


        do {
            System.out.println("What is your favorite programming Language");
             str=in.nextLine();
        }

        while(!str.equals("Java"));
        {
            System.out.println("That's what I was looking for! Java is definitely the answer!");
        }


    }
}
