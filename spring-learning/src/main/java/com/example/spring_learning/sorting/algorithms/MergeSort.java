package com.example.spring_learning.sorting.algorithms;

public class MergeSort {
    public static void main(String[] args) {
        int n = sortArray(new int[]{2,4,1,3,5,7,6,8}, 3);
        System.out.println(n);
    }
    public static int sortArray(int[] nums, int k) {
        mergeSort(nums, 0, nums.length-1);
        return nums[k-1];
    }
    private static void mergeSort(int[] nums, int left, int right) {
        if(left<right) {
            int mid = left + (right-left)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }
    private static void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] A = new int[n1];
        int[] B = new int[n2];
        for(int i=0; i<n1; i++) {
            A[i] = nums[left+i];
        }
        for(int i=0; i<n2; i++) {
            B[i] = nums[mid+i+1];
        }

        int i=0, j=0, k=left;
        while(i<n1 && j<n2) {
            if(A[i] <=  B[j]) {
                nums[k++] = A[i++];
            } else {
                nums[k++] = B[j++];
            }
        }
        while(i<n1) {
            nums[k++] = A[i++];
        }
        while(j<n2) {
            nums[k++] = B[j++];
        }
    }
}
