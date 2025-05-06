package com.example.spring_learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("[]{}(){}[]()() this string is a valid parentheses: " +
                (isValidParentheses("[]{}(){}[]()()") ? "Yes" : "No"));
    }

    private static boolean isValidParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}' , '{');
        map.put(']' , '[');
        map.put(')' , '(');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                char pop = !stack.isEmpty() ? stack.pop() : '#';
                if(pop != map.get(s.charAt(i))) return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
