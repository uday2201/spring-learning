package com.example.spring_learning.leetcode;

public class CountUniqueElements {
    public static void main(String[] args) {
        int[] array = new int[]{0,0,0,1,1,1,2,2,3,4};
        System.out.println("Initial Array is: \n");
        for(int num: array) {
            System.out.print(num + "->");
        }
        int[] uniqueArray = removeDuplicates(array);
        System.out.println("\nUnique Array is: \n");
        for(int num: uniqueArray) {
            System.out.print(num + "->");
        }
        System.out.println("\nLength of array with unique elements is: " +
            countArrayWithoutGivenValue(uniqueArray));
    }

    private static int countArrayWithoutGivenValue(int[] nums) {
        int k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    private static int[] removeDuplicates(int[] nums) {
        int p1=0, p2=0;
        while(p2<nums.length) {
            if(nums[p1] != nums[p2]) {
                p1++;
                nums[p1] = nums[p2];
            }
            p2++;
        }
        int[] uniqueArray = new int[p1+1];
        System.arraycopy(nums, 0, uniqueArray, 0, p1+1);
        return uniqueArray;
    }
}
