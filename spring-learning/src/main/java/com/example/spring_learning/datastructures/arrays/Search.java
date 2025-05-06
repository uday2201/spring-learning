package com.example.spring_learning.datastructures.arrays;

public class Search {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,4,6};
        int target = 4;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                System.out.println("Target " + target + " found at the index of " + i);
                break;
            }
        }
        int index = binarySearch(arr, target);
        System.out.println("Target " + target + " found at the index of " + index + " found using binary search.");
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}
