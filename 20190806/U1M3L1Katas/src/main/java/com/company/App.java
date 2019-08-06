package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size() - 1));
        strings.set(strings.size() - 1, temp);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {

       ArrayList<Integer> reversed = new ArrayList<>();


        for(int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(i, numbers.get(numbers.size() - (i + 1)));
        }

        return  reversed;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {

        List<Integer> numLessThanFive = new ArrayList<>();

        for(Integer num : numbers) {
            if ( num < 5 ) {
                numLessThanFive.add(num);
            }
        }

        if ( numLessThanFive.size() == 0 ) {
            return null;
        }

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables

        return numLessThanFive;
    }

    //challenge
    public static List<ArrayList<Integer>> splitAtFive(List<Integer> numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;


        for(Integer num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        List<Integer> lessThan = new ArrayList<>(numLessThanFive);
        List<Integer> moreThan = new ArrayList<>(numMoreThanFive);


        for(Integer num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan.add( num);
               // numLessThanFive--;
            } else {
                moreThan.add(num);
                //numMoreThanFive--;
            }
        }

        List<ArrayList<Integer>> split=new ArrayList<>();
        split.add((ArrayList<Integer>) lessThan);
        split.add((ArrayList<Integer>) moreThan);

        return  split;
    }

//    // Challenge
//    public static ArrayList<ArrayList<String>> evensAndOdds(ArrayList<String> strings) {
//
//        leveraging integer division
//        ArrayList<String> odds = new ArrayList<String>( strings.size()/2 );
//
//         Set evens to null for reassignment below
//        ArrayList<String> evens = null;
//
//         again leveraging integer division
//         if it's already of even length, we're good
//         but if it's of odd length, there's one more even index than odd
//        if (strings.size() % 2 == 0) {
//            evens = new ArrayList<String>( strings.size()/2);
//        } else {
//            evens = new ArrayList<String>( strings.size()/2 + 1);
//        }
//
//        for(int i = 0; i < strings.size(); i++) {
//            Integer currIndex = i/2;
//            if( i % 2 == 0 ) {
//                 evens.set(currIndex,String[i]);
//            } else {
//                odds[currIndex] = strings[i];
//            }
//        }
//
//        return new String[][] { evens, odds };
//    }
}
