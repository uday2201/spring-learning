package com.example.spring_learning.leetcode;

public class MiddleNumOfArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int sp = 0, fp =0;
        while (fp<arr.length) {
            sp += 1;
            fp += 2;
        }

        System.out.println("The middle most value in the array is "+ arr[sp-1]);
    }
}
