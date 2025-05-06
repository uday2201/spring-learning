package com.example.spring_learning.backtracking;

public class LeapCount {
    public static void main(String[] args) {
        int[] dp = new int[5];
        System.out.println("The total no.of ways monkey can leap is: " + leapCount(4, dp, 0));
    }

    public static int leapCount(int n, int[] dp, int count) {
        if(n<=0 || n==1) {
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != 0) return dp[n];
        for(int i=0; i<n; i++) {
            count += leapCount(i, dp, count);
        }
        dp[n] = count;
        return count;
    }
}
