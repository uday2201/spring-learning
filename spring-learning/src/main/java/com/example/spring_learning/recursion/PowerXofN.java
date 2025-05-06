package com.example.spring_learning.recursion;

public class PowerXofN {
    public static void main(String[] args) {
        System.out.println("The power of 5 over 4 is " + powerXOfNUsingRecursion(4, 5));
    }

    public static double powerXOfN(int x, int n) {
        double result = 1.0;
        long num = (long) Math.abs(n);
        while (num != 0 ) {
            if(num%2 ==1) {
                result *= x;
                num -= 1;
            }
            x *= x;
            num /= 2;
        }
        return result;
    }

    public static double powerXOfNUsingRecursion(int x, int n) {
        double result = 1.0;
        if(n==0) return 1;
        if(n==1) return x;
        double half = powerXOfNUsingRecursion(x, n/2);
        if(n%2 == 0) result=half*half;
        else result = x * half * half;
        return result;
    }
}
