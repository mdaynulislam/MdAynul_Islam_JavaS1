package com.company;
import java.util.Random;// enable random number

public class FortuneCookie {

    public static void main(String[] args) {
        Random rand= new Random();
        int lotto1= 1+rand.nextInt(54); //generating 1 to 54 random number for the Lotto
        int lotto2= 1+rand.nextInt(54);
        int lotto3= 1+rand.nextInt(54);
        int lotto4= 1+rand.nextInt(54);
        int lotto5= 1+rand.nextInt(54);
        int lotto6= 1+rand.nextInt(54);
        int val=1+rand.nextInt(6); // 1+ to start value form 1 not 0
        if(val==1){
            System.out.println("You will get a new Mirror less Camera");
        }else if(val==2){
              System.out.println("You will get $100k");
              }else if(val==3){
                    System.out.println("You will get a new BMW");
                    }else if(val==4){
                          System.out.println("You will be an actor");
                          }else if(val==5){
                                System.out.println("You will get a vacation package to Hollywood");
                                }else if(val==6){
                                       System.out.println("You will get a free ticket for Lion King");
                                     }else {
                                       System.out.println("bad Luck!!!");
                                     }

        System.out.println("Stick to your wife \n" +lotto1+ "-" +lotto2+ "-" +lotto3+ "-" +lotto5+ "-" +lotto6 );

    }
}
