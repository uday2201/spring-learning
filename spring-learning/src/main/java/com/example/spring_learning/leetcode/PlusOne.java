package com.example.spring_learning.leetcode;

public class PlusOne {
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9,9,9,9});
        for(int n: result) {
            System.out.println(n);
        }
    }

    private static int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
