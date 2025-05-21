package com.example.spring_learning.backtracking;

public class Anagrams {
  /**
   *
  */
  public static void main(String[] args) {
    char[] input = {'a', 'b', 'c'};
    anagrams(input, new char[input.length], new boolean[input.length], 0);
  }

  private static void anagrams(char[] input, char[] partial, boolean[] used, int index) {
    if (index == input.length) {
      System.out.println(partial);
      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (!used[i]) {
        used[i] = true;
        partial[index] = input[i];
        anagrams(input, partial, used, index + 1);
        used[i] = false;
      }
    }
  }
}
