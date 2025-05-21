// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2017. For more information see LICENSE

package com.example.spring_learning.backtracking;

import java.util.Set;

public class Selections {
  /**
   *
   */
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5};
    int k = 3;
    selections(input, k, new java.util.HashSet<>(), 0);
  }

  private static void selections(int[] input, int k, Set<Integer> set, int start) {
    if (set.size() == k) {
      System.out.println(set);
      return;
    }

    if (start == input.length) {
      return;
    }

    for (int i = start; i < input.length; i++) {
      set.add(input[i]);
      selections(input, k, set, i + 1);
      set.remove(input[i]);
    }
  }
}
