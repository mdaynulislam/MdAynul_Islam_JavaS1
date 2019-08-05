package com.company;
import java.util.Scanner;

public class Nim {

    public static void main(String[] args) {

        int A=3;
        int B=4;
        int C=5;
        Scanner sc=new Scanner(System.in);

        System.out.println(" Player 1, Enter you Name: ");
        String  pl1=sc.nextLine(); // name for player 1

        System.out.println(" Player 2, Enter you Name: ");
        String  pl2=sc.nextLine(); // name for player 2

        System.out.println("Your pile is A: 3\tB: 4\tC: 5"); //prompting user total numbers in pile

        //PLAYER 1 PORTION!!!!!!!!!!
        //PLAYER 1 PORTION!!!!!!!!!!
        System.out.println(pl1+", Choose a pile "); //prompting player 1 for pile
        String  a=sc.nextLine(); // pile string input

        System.out.println("How many to remove from pile "+a.toUpperCase()); //prompting for number to remove
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
        System.out.println("The pile is A:" +A+"\t "+"\tB:"+B+ "\t C:"+C);

        //PLAYER 2 PORTION********
        //PLAYER 2 PORTION********

        System.out.println(pl2+", Choose a pile "); //prompting player 2 for pile
          a=sc.nextLine(); // pile string input

        System.out.println("How many to remove from pile "+a.toUpperCase()); //prompting player 2 for number to remove
         num=Integer.parseInt(sc.nextLine()); // number input

        if (a.equals("A")||a.equals("a")){ // to allow user to use lower or upper case
            A=A-num;
        }
        if (a.equals("B")|| a.equals("b")){
                B=B-num;
        }
        if (a.equals("C")|| a.equals("c")){
                C=C-num;
        }

        System.out.println("The pile is A:" +A+"\t "+"\tB:"+B+ "\t C:"+C);

        while(A!=0 || B!=0 || C!=0){// it will keep prompting for number 3 pile become less than equal 0

            //System.out.println("The pile is A:" +A+"\t"+"\tB:"+B+ "\t C:"+C);

            //PLAYER 1 PORTION!!!!!!!!!!
            //PLAYER 1 PORTION!!!!!!!!!!
            System.out.println(pl1+", Choose a pile "); //prompting player 1 for pile
              a=sc.nextLine(); // pile string input


            System.out.println("How many to remove from pile "+a.toUpperCase()); //prompting for number to remove
             num=Integer.parseInt(sc.nextLine()); // number input

            if (a.equals("A")||a.equals("a")){ // to allow user to use lower or upper case
                A=A-num;
            }
            if (a.equals("B")|| a.equals("b")){
                B=B-num;
            }
            if (a.equals("C")|| a.equals("c")){
                C=C-num;
            }
            System.out.println("The pile is A:" +A+"\t"+"\tB:"+B+ "\t C:"+C);

            if ((A<=0) &&(B<=0) && (C<=0)) {
                System.out.println("The pile is A:" + A +"\t"+ "\tB:" + B + "\t C:" + C);
                System.out.println(pl2 + " ,There is no counter left. So you WIN!!!!");
                break;
            }

                //PLAYER 2 PORTION********
                //PLAYER 2 PORTION********
            //System.out.println("The pile is A:" +A+"\t "+"\tB:"+B+ "\t C:"+C);

                System.out.println(pl2+", Choose a pile "); //prompting player 2 for pile
                a=sc.nextLine(); // pile string input

                System.out.println("How many to remove from pile "+a.toUpperCase()); //prompting player 2 for number to remove
                num=Integer.parseInt(sc.nextLine()); // number input

                if (a.equals("A")||a.equals("a")){ // to allow user to use lower or upper case
                    A=A-num;
                }
                if (a.equals("B")|| a.equals("b")){
                    B=B-num;
                }
                if (a.equals("C")|| a.equals("c")){
                    C=C-num;
                }

            System.out.println("The pile is A:" +A+"\t"+"\tB:"+B+ "\t C:"+C);

            if ((A<=0) &&(B<=0) && (C<=0)) {
                System.out.println("The pile is A:" + A + "\t"+"\tB:" + B + "\t C:" + C);
                System.out.println(pl1 + " ,There is no counter left. So you WIN!!!!");
                break;
            }
        }
    }
}

