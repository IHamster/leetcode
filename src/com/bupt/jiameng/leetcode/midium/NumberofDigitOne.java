package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/16
 * Time: 下午2:23
 */

//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//    For example:
//    Given n = 13,
//    Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
public class NumberofDigitOne {
  public int countDigitOne(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int count = 0;
    for (long i = 1; i <= n; i *= 10) {
      long a = n / i;
      long b = n % i;
      count += (a+8) / 10 * i;
      if (a % 10 == 1) count += (b + 1);
    }
    return count;

  }

  public static void main(String[] args) {
    NumberofDigitOne n = new NumberofDigitOne();
    System.out.println(n.countDigitOne(20));
  }
}
