// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2017. For more information see LICENSE

package com.example.spring_learning.backtracking;

import java.util.Arrays;
import java.util.List;

public class Permutations {
  /**

  */
  public static void main(String[] args) {
    int[] input = {1, 2, 3};
    boolean[] used = new boolean[input.length];
    permutations(input, new java.util.ArrayList<>(), used);
  }

  private static void permutations(int[] input, List<Integer> partial, boolean[] used) {
    if (partial.size() == input.length) {
      System.out.println(Arrays.toString(partial.toArray()));
      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (!used[i]) {
        used[i] = true;
        partial.add(input[i]);
        permutations(input, partial, used);
        used[i] = false;
        partial.remove(partial.size() - 1);
      }
    }
  }
}
