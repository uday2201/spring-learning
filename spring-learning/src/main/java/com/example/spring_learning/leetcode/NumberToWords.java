package com.example.spring_learning.leetcode;

public class NumberToWords {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand",  "Million", "Billion", "Trillion"};

    public static void main(String[] args) {
        System.out.println("The word of number 1000234 is: " + numToWords(1000234));
    }

    public static String numToWords(int n) {
        if(n==0) return "Zero";
        int i=0;
        String word = "";
        while(n!=0) {
            word = helper(n%1000) + " " + THOUSANDS[i] + " " + word;
            n/=1000;
            i++;
        }
        return word;
    }

    private static String helper(int num) {
        if(num==0) return "";
        if(num<20) return LESS_THAN_20[num];
        else if(num<100) return num%10 != 0 ? TENS[num/10] + " " + helper(num%10) : TENS[num/10];
        else return num%100 != 0 ? LESS_THAN_20[num/100] + " Hundred " + helper(num%100) : LESS_THAN_20[num%100]
            + " Hundred";
    }
}
