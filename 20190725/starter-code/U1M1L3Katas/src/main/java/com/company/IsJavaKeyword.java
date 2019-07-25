package com.company;
import java.util.Scanner; // enable I/O

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in); //input from user
        System.out.println("Enter a word");
        String str=in.nextLine(); // putting the input in str

        if // took all keyword from oracle site and check with .equals & with logical OR operator
        (str.equals("abstract")||str.equals("assert")||str.equals("boolean")||str.equals("break")||str.equals("byte")||str.equals("case")
                ||str.equals("catch")||str.equals("char")||str.equals("class")||str.equals("const")||str.equals("continue")||str.equals("default")
                ||str.equals("do")||str.equals("double")
                ||str.equals("else")||str.equals("enum")||str.equals("extends")||str.equals("final")||str.equals("finally")||str.equals("float")
                ||str.equals("for")||str.equals("goto")||str.equals("if")||str.equals("implements")||str.equals("import")||str.equals("instanceof")
                ||str.equals("int")||str.equals("interface")||str.equals("long")||str.equals("native")||str.equals("new")||str.equals("package")
                ||str.equals("private")||str.equals("protected")||str.equals("public")||str.equals("return")||str.equals("short")||str.equals("static")
                ||str.equals("strictfp")||str.equals("super")||str.equals("switch")||str.equals("synchronize")||str.equals("this")||str.equals("throws")
                ||str.equals("transient")||str.equals("try")||str.equals("void")||str.equals("volatile")||str.equals("while"))
        {
            System.out.println("This is a Java Keyword");
        }

        else
        {
            System.out.println("This is not a Java keyword");
        }

    }

}