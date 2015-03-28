package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/3/29.
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    int[] sum = new int[digits.length + 1];
    int cache = 0;//保存进位
    for (int i = 0; i < digits.length; i++) {
      int tmp = 0;
      int a = digits[digits.length - i - 1];
      if (i == 0) {
        tmp = a + 1;
      } else
        tmp = a + cache;
      sum[digits.length - i] = tmp % 10;
//      System.out.println(sum[digits.length-i]);
      cache = tmp / 10;
    }
    if (cache != 0) {
      sum[0] = cache;
      return sum;
    } else {
      for (int j = 0; j<sum.length-1;j++){
        digits[j] = sum[j+1];
      }
      return digits;
    }
  }

  public static void main(String[] args){
    PlusOne p = new PlusOne();
    int[] a = {0};
    p.plusOne(a);
    for(int t:p.plusOne(a))
      System.out.println(t);
  }
}
