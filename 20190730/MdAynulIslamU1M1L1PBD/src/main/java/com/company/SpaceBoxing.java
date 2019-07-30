package com.company;
import java.util.Scanner;

public class SpaceBoxing {

    public static void main(String[] args) {
        double weight;
        int planet;

        System.out.println("Please Enter your weight");

        Scanner in=new Scanner(System.in);
        weight=Double.parseDouble(in.nextLine());

        System.out.println("I have information for the following planets:\n" +
                "   1. Venus   2. Mars    3. Jupiter\n" +
                "   4. Saturn  5. Uranus  6. Neptune");

        System.out.println("Which planet are you visiting");
        Scanner pl=new Scanner(System.in);
        planet=Integer.parseInt(pl.nextLine());
        if(planet==1) {
            System.out.println("Your weight would be " + (weight * 0.78) + " pounds on that planet");
        }else if(planet==2){

                System.out.println("Your weight would be " + (weight * 0.39) + " pounds on that planet");
             }else if(planet==3){
                    System.out.println("Your weight would be " + (weight * 2.65) + " pounds on that planet");
                   }else if(planet==4){
                         System.out.println("Your weight would be " + (weight * 1.17) + " pounds on that planet");
                         }else if(planet==5){
                               System.out.println("Your weight would be " + (weight * 1.05) + " pounds on that planet");
                                }else if(planet==6){
                                      System.out.println("Your weight would be " + (weight * 1.23) + " pounds on that planet");
                                      }
    }
}



