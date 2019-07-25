package com.company;
import java.util.Scanner;
public class App {

    public static int subtract(int a, int b) {

        return (a-b);

    }
    public static int subtractOrZero(int a, int b){

        if((a-b)>0)
            return (a-b);
        else
            return 0;
    }

    public static int max(int a, int b, int c){

        if ((a>b) && (a>c))
            return (a);
        if((b>a) && (b>c))
            return (b);
        else
            return (c);
    }
    public static int min(int a, int b, int c){

        if ((a<b) && (a<c))
            return (a);
        if((b<a) && (b<c))
            return (b);
        else
            return (c);
    }

    public static boolean isLarger(int first,int second) {

        if (first > second)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
         //int a =10;
        //int b = 5;
        System.out.println(subtract(10,5));
        System.out.println(subtractOrZero(1,5));
        System.out.println(max(9,5,6));
        System.out.println(min(9,5,6));
        System.out.println(isLarger(7,9));



    }
}