package com.company;

public class App {

    public static void main(String[] args) {

        Calculator calculate = new Calculator();

                System.out.println("Addition of Two integer "+calculate.add(1,1));
                System.out.println("Subtraction of Two integer "+calculate.subtract(23,52));
                System.out.println("Multiplication of Two integer "+calculate.multiply(34,2));
                System.out.println("Division of Two integer "+calculate.divide(12,3));
                System.out.println("Division of Two different integer "+calculate.divide(12,7));


        System.out.println("Addition of Two double "+calculate.add(3.4,2.3));
        System.out.println("Subtraction of Two double "+calculate.subtract(5.5,0.5));
        System.out.println("Multiplication of Two double "+calculate.multiply(6.7,4.4));
        System.out.println("Division of Two double "+calculate.divide(10.8,2.2));

    }
}
