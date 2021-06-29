package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3_5 {
    public static void main(String[] args) {
        printHelloWorld(new int[]{5, 7, 35, 9});
        int[] arr = new int[]{19,9,11,0,12};
        int theSecondMax = findSecondBiggest(arr);
        System.out.printf("the second biggest is %d\n",
                theSecondMax);
    }

    private static int findSecondBiggest(int[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException("Array too small!");
        int imax = 0, imax2;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] > arr[imax]) imax = i;
        }
        imax2 = imax == 0 ? 1 : 0;
        for (int i = imax2 + 1; i < arr.length; i++) {
            if(i == imax) continue;
            if(arr[i] > arr[imax2]) imax2 = i;
        }
        return arr[imax2];
    }

    public static void printHelloWorld(int[] nums) {
        for (int num : nums) {
            if (num % 5 == 0)
                System.out.print("Hello");
            if (num % 7 == 0)
                System.out.print("World");
            System.out.println();
        }
    }


}

