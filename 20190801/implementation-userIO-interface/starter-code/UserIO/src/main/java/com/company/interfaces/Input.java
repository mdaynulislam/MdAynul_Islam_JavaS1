package com.company.interfaces;
import java.util.Scanner;
public class Input implements UserIO{

    Scanner sc=new Scanner(System.in);


    public int readInt(String prompt){
        System.out.println(prompt);
        int a=Integer.parseInt(sc.nextLine());
        return a;

    }
    public long readLong(String prompt){
        System.out.println(prompt);
        long a=Long.parseLong(sc.nextLine());
        return a;

    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        double a= Double.parseDouble(sc.nextLine());
        return a;

    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        float a= Float.parseFloat(sc.nextLine());
        return a;

    }
    public String readString(String prompt){
        System.out.println(prompt);
        String a =sc.nextLine();
        return a ;
        
    }
}
