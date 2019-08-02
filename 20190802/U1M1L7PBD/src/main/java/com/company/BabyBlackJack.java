package com.company;
import java.util.Random;

public class BabyBlackJack {

    public static void main(String[] args) {

        int user;
        int dealer;


        int i,j,k,l;
        Random rand=new Random();
        i=1+rand.nextInt(10);
        j=1+rand.nextInt(10);
        k=1+rand.nextInt(10);
        l=1+rand.nextInt(10);

        user=i+j;
        System.out.println("You drew " +i+ " and "+j+ "\n" +
                           "Your total is " +user);
        dealer=k+l;

        System.out.println("Dealer drew " +k+ " and "+l+ "\n" +
                           "Your total is " +dealer);

      if(user>dealer){

          System.out.println("You Win!!!!!!");
      }else {
          System.out.println("Dealer Win this time!!!!");
      }

    }
}
