package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {


    public void printSet(int a,int b, int c,int d,int e){

        Set<Integer> set=new HashSet<>();

        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);


        Iterator<Integer> allElement= set.iterator();
        while (allElement.hasNext()){

            System.out.println(+allElement.next());
        }

    }
}
