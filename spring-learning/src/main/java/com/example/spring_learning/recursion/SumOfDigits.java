// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2017. For more information see LICENSE

package com.example.spring_learning.recursion;

public class SumOfDigits {
  public static void main(String[] args) {
    System.out.println("The sum of digits of 1234 is " + sumOfDigits(1234));
  }

  public static int sumOfDigits(int n) {
    return n % 10 + (n == 0 ? 0 : sumOfDigits(n / 10));
  }
}
