package com.example.spring_learning.leetcode;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println("String anagram and nagaram are valid anagrams: " + isValidAnagram("uday",
        "dayu"));
    }

    private static boolean isValidAnagram(String s , String t) {
        if(s.length() != t.length()) return  false;
        int[] c = new int[26];
        for(int i=0; i<s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }
        for(int num: c) {
            if(num != 0) return false;
        }
        return true;
    }
}
