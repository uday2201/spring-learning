package com.example.spring_learning.sorting.algorithms;

public class SelectionSort {

    public static void main(String[] args) {
        for(int n1: selectionSortDesc(new int[]{2,4,1,3,5,7,6,8})) {
            System.out.println(n1);
        }
        System.out.println("<<<<<>>>>>>");
        for(int n1: selectionSortAsc(new int[]{2,4,1,3,5,7,6,8})) {
            System.out.println(n1);
        }
    }
    public static int[] selectionSortDesc(int[] numArr) {
        int temp  = 0, maxIndex= -1;
        for(int i=0; i<numArr.length; i++) {
            maxIndex=i;
            for(int j=i+1; j<numArr.length; j++) {
                if(numArr[maxIndex] < numArr[j]) maxIndex = j;
            }
            temp = numArr[i];
            numArr[i] = numArr[maxIndex];
            numArr[maxIndex] = temp;
        }
        return numArr;
    }

    public static int[] selectionSortAsc(int[] numArr) {
        int minIndex = -1, temp = 0;
        for(int i=0;i<numArr.length; i++) {
            minIndex = i;
            for(int j=i+1; j<numArr.length; j++) {
                if(numArr[minIndex] > numArr[j]) minIndex = j;
            }
            temp = numArr[minIndex];
            numArr[minIndex] = numArr[i];
            numArr[i] = temp;
        }
        return numArr;
    }
}
