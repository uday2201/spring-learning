// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2017. For more information see LICENSE

package com.example.spring_learning.recursion;

public class IsSequence {
  public static void main(String[] args) {
    System.out.println(isSequence(new int[]{1, 2, 3, 4, 5}, 0)); // true
  }

  public static boolean isSequence(int[] arr, int n) {
    return n == arr.length - 1 || arr[n] == arr[n + 1] - 1 && isSequence(arr, n + 1);
  }
}
