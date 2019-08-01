package com.company;
import java.util.Arrays;
public class ArrayFunReverseIt {



    public static void main(String[] args) {

        int[] array = {1,2,3,4,5};
        int [] newArray = new int[5];
        int left = 0;
        int right = array.length - 1;

        while( left < right ) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        for(int i = 0; i < 5; i++){
            newArray[i] = array[i];
        }

        System.out.println(Arrays.toString(newArray));

    }
}
