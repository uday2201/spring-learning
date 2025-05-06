package com.example.spring_learning.datastructures.strings;

public class Operations {
    public static void main(String[] args) {
        System.out.println("The string madam is a valid palindrome: " + isPalindrome("racecars", 0, 6));

        System.out.println("The string madam is a valid palindrome: " + isPalindrome("madam"));
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start+1, end-1);
    }

    public static boolean isPalindromeUsingReverse(String s) {
        int lp=0, rp=s.length()-1;
        char[] arr = s.toCharArray();
        while(lp<=rp) {
            char temp = arr[lp];
            arr[lp] = arr[rp];
            arr[rp] = temp;
            lp++;
            rp--;
        }
        String reversedStr = new String(arr);
        return s.equals(reversedStr);

    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
