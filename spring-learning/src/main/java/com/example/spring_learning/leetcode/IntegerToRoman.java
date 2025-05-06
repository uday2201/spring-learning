package com.example.spring_learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        int[] romanVals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String result = "";
        for(int i=0; i<romans.length; i++) {
            while(number >= romanVals[i]) {
                result += romans[i];
                number -= romanVals[i];
            }
        }
        System.out.println("The roman values of number " + number + " is " + result);
        sc.close();

        System.out.println("The number value of roman " + result + " is " + romanToInt(result));
    }

    public static int romanToInt(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('C', 100);
        map.put('D', 500);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int prev = 0;
        int result = 0;
        for(int i=roman.length()-1; i>=0; i--) {
            int curr = map.get(roman.charAt(i));
            if(prev > curr) result -= curr;
            else result += curr;
            prev = curr;
        }

        return result;
    }
}
