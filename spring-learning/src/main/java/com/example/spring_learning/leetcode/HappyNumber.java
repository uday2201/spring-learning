package com.example.spring_learning.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println("The number 19 is happy number " + isHappyNum(19));
    }

    private static boolean isHappyNum(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSumOfDigitsSquared(n);
        }
        return n == 1;
    }

    private static int getSumOfDigitsSquared(int n) {
        int result = 0;
        while (n != 0) {
            int digit = n%10;
            result += digit*digit;
            n /= 10;
        }
        return result;
    }
}
