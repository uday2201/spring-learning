package com.example.spring_learning.sorting.algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        for(int n2: insertionSort(new int[]{2,4,1,3,5,7,6,8})) {
//            System.out.println(n2);
        }
    }
    public static int[] insertionSort(int[] nums) {
        int j=0, key=0;
        for(int i=1; i<nums.length; i++) {
            key=nums[i];
            j=i-1;
            while(j>=0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j -= 1;
            }
            nums[j+1] = key;
            System.out.println("The Array elements after each iteration of count " + i);
            Arrays.stream(nums).forEach(System.out::println);
            System.out.println(">>>>>>>><<<<<<<<<<");
        }
        return nums;
    }
}
