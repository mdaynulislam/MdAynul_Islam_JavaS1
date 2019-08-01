package com.company;
import java.util.Scanner;
public class SomeMath {

    public static void main(String[] args) {


        System.out.println("The total is "+total5(1,2,3,4,5));
        System.out.println("The average is "+average5(1,3,5,7,9));
        System.out.println("The largest number is "+largest5(42.0,35.1,2.3,40.2,15.6));

    }

    public static int total5(int n1,int n2, int n3,int n4, int n5){
        int sum;
        sum=n1+n2+n3+n4+n5;
        return sum;
    }
    public static int average5(int n1,int n2, int n3,int n4, int n5){
        int avg;
        avg=(n1+n2+n3+n4+n5)/5;
        return avg;
    }
    public static double largest5(double n1,double n2, double n3,double n4, double n5){
        double lar;
        if((n1>n2) && (n1>n3) && (n1>n4) && (n1>n5)){
            lar=n1;
          }else if((n2>n1) && (n2>n3) && (n2>n4) && (n2>n5)){
            lar=n2;
           }else if((n3>n1) && (n3>n2) && (n3>n4) && (n3>n5)){
            lar=n3;
              }else if((n4>n1) && (n4>n2) && (n4>n4) && (n3>n5)){
            lar=n4;
                }else {
            lar=n3;
                }

        return lar;
    }

}


