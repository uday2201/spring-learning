package com.example.spring_learning.datastructures.arrays;

public class Rotate {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
//        rightRotate(arr, 3);
//        for(int num: arr) {
//            System.out.println(num);
//        }

        System.out.println(">>>>>>>>>><<<<<<<<<<");

        leftRotate(arr, 3);
        for(int num: arr) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] arr, int left, int right) {
        while(left<right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void rightRotate(int[] arr, int k) {
        rotate(arr, 0, arr.length-1);
        rotate(arr, 0, k-1);
        rotate(arr, k, arr.length-1);
    }

    public static void leftRotate(int[] arr, int k) {
        rotate(arr, 0, k-1);
        rotate(arr, k, arr.length-1);
        rotate(arr, 0, arr.length-1);
    }
}
