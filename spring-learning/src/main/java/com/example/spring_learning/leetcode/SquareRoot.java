package com.example.spring_learning.leetcode;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("Square root of 16 is : " + sqrt(16));
    }

    private static int sqrt(int num) {
        int left = 1, right = num, result = 0;
        while (left<=right) {
            int mid = left + (right-left)/2;
            long sqr = (long) mid *mid;
            if(sqr==num) return mid;
            else if (sqr>num) {
                right = mid -1;
            } else {
                result = mid;
                left = mid+1;
            }
        }
        return result;
    }
}
