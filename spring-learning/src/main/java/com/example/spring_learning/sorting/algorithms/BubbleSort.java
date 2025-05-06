package com.example.spring_learning.sorting.algorithms;

public class BubbleSort {

    public static void main(String[] args) {
        for(int n: bubbleSort(new int[]{2,4,1,3,5,7,6,8})) {
            System.out.println(n);
        }
    }

    public static int[] bubbleSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length-i-1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
