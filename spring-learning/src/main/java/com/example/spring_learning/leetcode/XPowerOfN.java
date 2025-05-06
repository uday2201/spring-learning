package com.example.spring_learning.leetcode;

public class XPowerOfN {
    public static void main(String[] args) {
        System.out.println("2 power of 10 is: " + powUsingRecursion(2, 10));
    }

    private static double pow(int x, int n) {
        long num = (long) Math.abs(n);
        double power = 1.0;
        while (num != 0) {
            if(num%2==1) {
                power *= x;
                num -= 1;
            }
            x *= x;
            num /= 2;
        }
        return n > 0 ? power : 1/power;
    }

    private static double powUsingRecursion(int x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        double power = 1.0;
        double half = powUsingRecursion(x, n/2);
        if(n%2==0) power = half*half;
        else power = x*half*half;
        return power;
    }
}
