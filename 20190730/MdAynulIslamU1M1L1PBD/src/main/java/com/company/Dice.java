package com.company;
import java.util.Random;// enable random Input

public class Dice {

    public static void main(String[] args) {

        Random rand=new Random();
        int roll1=1+rand.nextInt(6);
        int roll2=1+rand.nextInt(6);
        System.out.println("HERE COMES THE DICE!\n" +
                "\n" +
                "Roll #1: " +roll1+"\n" +
                "Roll #2: " +roll2+"\n" +
                "The total is " +(roll1+roll2)+ "!");

    }
}
