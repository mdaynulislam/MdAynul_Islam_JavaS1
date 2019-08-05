package com.company;
import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {

        int A=3;
        int B=3;
        int C=3;

        System.out.println("Your pile is A: 3\tB: 3\tC: 3"); //prompting user total numbers in pile

        System.out.println("Choose a pile");

        Scanner sc=new Scanner(System.in);

        String  a=sc.nextLine(); // pile string input

        System.out.println("How many to remove from pile "+a); //prompting for number to remove

        int num=Integer.parseInt(sc.nextLine()); // number input


        if (a.equals("A")||a.equals("a")){ // to allow user to use lower or upper case
            A=A-num;
        }
        if (a.equals("B")|| a.equals("b")){
            B=B-num;
        }
        if (a.equals("C")|| a.equals("c")){
            C=C-num;
        }

        while(A<=0 || B<=0 || C<=0){// it will keep prompting for number 3 pile become less than equal 0

            System.out.println("Your pile is A:" +A+"\tB:"+B+ "\t C:"+C);

            System.out.println("Choose a pile");

            a=sc.nextLine();

            System.out.println("How many to remove from pile "+a);

             num=Integer.parseInt(sc.nextLine());
            if (a.equals("A")||a.equals("a")){
                A=A-num;
            }
            if (a.equals("B")|| a.equals("b")){
                B=B-num;
            }
            if (a.equals("C")|| a.equals("c")){
                C=C-num;
            }


                if ((A<=0) &&(B<=0) && (C<=0)){
                    System.out.println("Your pile is A:" +A+"\tB:"+B+ "\t C:"+C);
                    System.out.println("All piles are empty. Good job!");
                    break;
                }


            }
    }

}

