package com.example.spring_learning.backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Dictionary {
  /**
   * Given a string and a dictionary, find all possible ways to break the string into words
   * present in the dictionary.
   *
  */
  public static void main(String[] args) {
    String input = "catsanddog";
    Set<String> dict = Set.of("cat", "cats", "and", "sand", "dog");
    wordBreak(input, dict, new java.util.ArrayList<>());
  }

  private static void wordBreak(String input, Set<String> dict, List<String> partial) {
    if (input.isEmpty()) {
      System.out.println(Arrays.toString(partial.toArray()));
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      String prefix = input.substring(0, i + 1);
      if (dict.contains(prefix)) {
        partial.add(prefix);
        wordBreak(input.substring(i + 1), dict, partial);
        partial.remove(partial.size() - 1);
      }
    }
  }
}
