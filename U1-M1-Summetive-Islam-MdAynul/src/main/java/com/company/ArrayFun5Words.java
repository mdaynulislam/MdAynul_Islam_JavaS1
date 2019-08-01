package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayFun5Words {

        public static void main(String[] args) {

            String[] output=new String[5];

            int i;
            System.out.println("Enter five words ");
            Scanner sc=new Scanner(System.in);


            for( i=0;i<output.length;i++){ //traversing the array

                String userInput=sc.nextLine();
                output[i]=userInput;
            }

            System.out.println(" the elements are " +Arrays.toString(output)); // printing array with toString.
        }
}

