package com.example.spring_learning.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("The longest common prefix in the given array of words is: "
        + longestCommonPrefix(new String[]{"leetcode", "leetme", "leet"}));
    }

    private static String longestCommonPrefix(String[] words) {
        String prefix = words[0];
        for (int i=1; i<words.length; i++) {
            while(words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.isEmpty()) return "";
        }
        return prefix;
    }
}
