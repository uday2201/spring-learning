package com.example.spring_learning.edit_distance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NaiveApproach {
    public static void main(String[] args) {
        System.out.print("The minimum num of operations required to make \"GEEXSFRGEEKKS\" into \"GEEKSFORGEEKS\" is :"
             + editDistance("GEEXSFRGEEKKS", "GEEXSFRGEEKKS".length(), "GEEKSFORGEEKS", "GEEKSFORGEEKS".length()));

        System.out.println("\n");

        System.out.print("\nThe minimum num of operations required to make \"GEEXSFRGEEKKS\" into \"GEEKSFORGEEKS\" is :"
            + editDistance("GEEXSFRGEEKKS","GEEKSFORGEEKS"));

        List<Employee> employees = Arrays.asList(
                new Employee("Uday", 250000),
                new Employee("Neha", 150000),
                new Employee("Akki", 350000),
                new Employee("Uday", 50000),
                new Employee("Mittu", 450000),
                new Employee("Avinya", 200000)
        );

        Employee highestPaid = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();

    }

    //Using recursion where we need to have base cases.
    //As i here the base cases are: 1) If the target string is empty the directly return m, as we need m removals to achieve the distance.
    // 2) Similarly if source is empty, then return n as we need n insertions.

    private static  int editDistance(String s, int m, String t, int n) {
        int counter = 0;
        if(m==0) return n; // if first string is empty, we can simply return n as it requires n insertions.
        if(n==0) return m; // if second string is empty, we can simply return m as it requires m removals.
        if(s.charAt(m-1) == t.charAt(n-1)) return editDistance(s,m-1, t, n-1);
        System.out.println("No.Of Iterations in naive approach is " + counter++);
        return 1 + Math.min(Math.min(editDistance(s, m-1, t, n), editDistance(s, m, t, n-1)),
            editDistance(s, m-1, t, n-1));
    }

    private static int editDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return editDistance(s, m, t, n, memo);
    }

    private static int editDistance(String s, int m, String t, int n, int[][] memo) {
        int counter = 0;
        if(m==0) return n;
        if(n==0) return m;
        if (memo[m][n] != -1) return memo[m][n];
        if(s.charAt(m-1) == t.charAt(n-1)) {
            return memo[m][n] = editDistance(s, m-1, t, n-1, memo);
        }
        System.out.println("No.Of Iterations in naive approach is " + counter++);
        return memo[m][n] = 1 + Math.min(Math.min(editDistance(s, m, t, n-1, memo),
                editDistance(s, m-1, t, n, memo)), editDistance(s, m-1, t, n-1, memo));
    }


}
