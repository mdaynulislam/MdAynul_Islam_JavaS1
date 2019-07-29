package com.company;


public class App {

    public static int total(int[] inputArray1){

        int sum=0;
       for(int i=0; i<inputArray1.length;i++){ //Traversing the array
           sum+=inputArray1[i]; //adding all the elements
       }
       return sum;
    }

    public static int totalOdd(int[] inputArray2){

        int sumOdd=0;
        for(int i=0;i<inputArray2.length;i++){
            if(i%2!=0) //logic that find the odd
            sumOdd+=inputArray2[i];
        }
        return sumOdd;
    }

    public static int totalEven(int[] array3){
        int sumEven=0;
        for(int i=0; i<array3.length;i++){

            if(i%2==0)//finding the even
                sumEven+=array3[i];
        }
        return sumEven;
    }

    public static int secondLargestNumber(int[] array4){
        int temp = 0,size;
        size=array4.length;
        for(int i=0;i<size;i++){
            for(int j=0; j<size; j++) {

                if (array4[j] < array4[i]) {
                    temp=array4[i];
                    array4[i] = array4[j];
                    array4[j] = temp;
                }
            }
        }
        return array4[1];
    }

    public static String[] swapFirstAndLast(String[] array5){
       String temp;
        temp=array5[0];
        array5[0]=array5[array5.length-1];
        array5[array5.length-1]=temp;
        return array5;
    }

    public static int[] reverse(int[] array6){
        int temp;
        for(int i=0; i<array6.length/2;i++) { //checking until the middle because we are just swapping the elements
             temp = array6[i];
            array6[i] = array6[array6.length - i - 1];
            array6[array6.length - i - 1] = temp;
        }
        return array6;
    }

    public static String concatenateString(String[] array7){
        String temp = ""; //initializing without null
        for(int i=0;i<array7.length;i++){
            temp+=array7[i]; //joining all element in array with +=
        }
        return temp;
    }

    public static int[] everyThird(int[] array8){
        int[] thirdVal=new int[array8.length/3]; //initialize a new array for the output which is thirdVal
        int j=0;
        if (array8.length>3){
            for(int i=2;i<array8.length;i+=3){ //Traversing starting from 2 because that's the first 3rd element and increment by 3
                thirdVal[j]=array8[i];// passing the values into output array and increment the index by j++
                j++;
            }
        }else { //if the array is only two in length it won't find any third elements and will return null
            return null;
        }
        return thirdVal;
    }

    public static int[] lessThanFive(int[] array9){
        int j=0;
        int k=0;
        for(int i=0;i<array9.length;i++){ //counting how many less than 5 elements in the array to decide the length of the output array.
            if(array9[i]<5){
                j++;
            }
        }
        int[] lessFive=new int [j]; //initialize the output array with the length that found

        for(int i=0;i<array9.length;i++){ //Traversing the array
            if (array9[i]<5){
                lessFive[k]=array9[i]; //passing the elements into output array and incrementing the index by k++
                k++;
            }else if(lessFive.length==0){ //checking if the array contains no less than 5 elements
                return null;
            }
        }
        return lessFive;
    }

    public static void main(String[] args) {

    }

}
