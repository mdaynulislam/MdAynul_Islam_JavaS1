package com.company;
import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {

        Random rand=new Random();

        int roll1=1+rand.nextInt(6);
        int roll2=1+rand.nextInt(6);

      while(roll1!=roll2){


          if(roll1==roll2){
              System.out.println("Roll #1 "+roll1);
              System.out.println("Roll #2 "+roll2);
              System.out.println("The total is "+(roll1+roll2));
          }else {
              roll1=1+rand.nextInt(6);
              roll2=1+rand.nextInt(6);
              System.out.println("Roll #1 "+roll1);
              System.out.println("Roll #2 "+roll2);
              System.out.println("The total is "+(roll1+roll2));

          }
      }

    }
}
