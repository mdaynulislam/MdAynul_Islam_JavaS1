package com.company;
import java.util.ArrayList;

public class ClassmatesList {

    private ArrayList<Classmate> classmates=new ArrayList<>();

    public void add(Classmate m){

        this.classmates.add(m);
    }

    public Classmate get(int g){

        return this.classmates.get(g);
    }

    public ArrayList<Classmate> getAll(){

        return this.classmates;
    }





}
