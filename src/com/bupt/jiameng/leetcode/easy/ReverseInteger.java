package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/10
 * Time: 下午8:58
 */
//Reverse digits of an integer.
//
//    Example1: x = 123, return 321
//    Example2: x = -123, return -321
public class ReverseInteger {
  public int reverse(int x) {

    long sum = 0;
    int sign = 1;
    if(x<0) {
      x = -1*x;
      sign = -1;
    }
    while(x >0){
      sum = sum*10 + x%10;
      if(sum > 2147483647) return 0;
      x = x/10;
    }

    return (int) sum*sign;
  }

  public static void main(String[] args){
    ReverseInteger r = new ReverseInteger();
    int a = 100100;
    System.out.println(r.reverse(a));
  }

}
