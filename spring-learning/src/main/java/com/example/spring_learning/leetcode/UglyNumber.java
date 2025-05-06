package com.example.spring_learning.leetcode;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println("The number 90 is an ugly number " + isUglyNum(90));
    }

    //upgrade in switch statement
    private static String dayOfWeek(int day) {
        return switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday, which is a working day, uffff";
            case 6, 7 -> "Weekend, sit-back and relax!!!!";
            default -> throw  new IllegalArgumentException("Not a valid argument");
        };
    }

    private static boolean isUglyNum(int n) {
        int[] primes = new int[]{2, 3, 5};
        for(int num: primes) {
            while (n%num  == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
