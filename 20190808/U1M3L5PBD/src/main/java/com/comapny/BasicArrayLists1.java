package com.comapny;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {

        List<Integer> numbers=new ArrayList<>();
            while(numbers.size()<10){ // defining the size
                numbers.add(-113); // populating the array
            }
        for(int i=0;i<10;i++){
            System.out.println("slot "+i+" contains " +numbers.get(i) );
            }
    }
}
