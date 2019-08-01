package com.company;
import java.util.Scanner;

public class AddingValuesInALoop {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int i =Integer.parseInt(sc.nextLine());
        int sum=0;

        while (i!=0){
             sum=sum+i;

            System.out.println("So far the total is " +sum);
             i =Integer.parseInt(sc.nextLine());

        }
        System.out.println("So far the total is " +sum);

    }
}
