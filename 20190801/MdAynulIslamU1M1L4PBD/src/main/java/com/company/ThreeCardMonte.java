package com.company;
import java.util.Scanner; // enable I/O
import java.util.Random; // enable random number
public class ThreeCardMonte {

    public static void main(String[] args) {


        Random rand = new Random();
        int ace = 1 + rand.nextInt(3); // generates 1,2,3 not 0
        System.out.println(ace);
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.");

        System.out.println("Which one is the ace?\n" +
                                                "\n" +
                                    "\t##  ##  ##\n" +
                                    "\t##  ##  ##\n" +
                                     "\t1   2   3");

        Scanner sc = new Scanner(System.in);
        int guess = Integer.parseInt(sc.nextLine());

        if (guess != ace) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + ace + ".");

            if (ace == 1) {
                System.out.println("\tAA  ##  ##\n" +
                                   "\tAA  ##  ##\n" +
                                   "\t1   2   3");
            } else if (ace == 2) {
                System.out.println("\t##  AA  ##\n" +
                                   "\t##  AA  ##\n" +
                                   "\t1   2   3");

            } else {
                System.out.println("\t##  ##  AA\n" +
                                   "\t##  ##  AA\n" +
                                    "\t1   2   3");

            }
        } else {

            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");

            if (guess == 1) {
                System.out.println("\tAA  ##  ##\n" +
                                   "\tAA  ##  ##\n" +
                                    "\t1   2   3");
            } else if (guess == 2) {
                System.out.println("\t##  AA  ##\n" +
                                   "\t##  AA  ##\n" +
                                    "\t1   2   3");

            } else {
                System.out.println("\t##  ##  AA\n" +
                                   "\t##  ##  AA\n" +
                                   "\t1   2   3");
            }

        }
    }
}
