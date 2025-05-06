package com.example.spring_learning.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        helper("abc", 0, "", result);
        for(String s: result) {
            System.out.println(s);
        }
        System.out.println(countOfSubSequences("abc", 0) - 1);
    }

    public static void helper(String s, int i, String curr, List<String> result)  {
        if(i==s.length()) {
            result.add(curr);
            return;
        }
        helper(s, i+1, curr+s.charAt(i), result);
        helper(s, i+1, curr, result);
    }

    public static int countOfSubSequences(String s, int i) {
        if(i==s.length()) return 1;
        return countOfSubSequences(s, i+1) + countOfSubSequences(s, i+1);
    }
}
