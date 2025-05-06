package com.example.spring_learning.datastructures.arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {2,4,5,3,6,1};
        System.out.println(">>>>>>Quick Sort<<<<<<");
        quickSort(arr, 0, arr.length-1);
        for(int num: arr) {
            System.out.println(num);
        }

        System.out.println(">>>>>>Insertion Sort<<<<<<");
        insertionSort(arr);
        for(int num: arr) {
            System.out.println(num);
        }

        System.out.println(">>>>>>Selection Sort<<<<<<");
        selectionSort(arr);
        for(int num: arr) {
            System.out.println(num);
        }
    }

    public static void insertionSort(int[] nums) {
        int j =0, key=0;
        for(int i=1; i<nums.length; i++) {
            j=i-1;
            key=nums[i];
            while(j>=0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j -= 1;
            }
            nums[j+1] = key;
        }
    }

    public static void selectionSort(int[] nums) {
        int temp =0, maxIndex=0;
        for(int i=0; i<nums.length-1; i++) {
            maxIndex = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] < nums[i]) maxIndex = j;
            }
            temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1); // left part
            quickSort(arr, pi + 1, high); // right part
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1;
        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
