package com.company;
import java.util.Scanner;

public class ArrayFunUserArray {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);



        int[] array=new int[5];

        for(int i=0;i<array.length;i++){

            System.out.println("Enter your number : ");
            int input= Integer.parseInt(sc.nextLine());
            array[i]=input;

        }
        System.out.println("The elements in array are ");
        for(int element:array){

            System.out.print(element+"\t");
        }


    }
}
