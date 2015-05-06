package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/5/3
 * Time: 下午10:37
 */
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//    For example, given the range [5, 7], you should return 4.
//
public class BitwiseANDofNumbersRange {
  public int rangeBitwiseAnd(int m, int n) {
    while(m<n){
      n = n&(n-1);
    }
    return n;
  }

  public static void main(String[] args){
    BitwiseANDofNumbersRange b  = new BitwiseANDofNumbersRange();
    System.out.println(b.rangeBitwiseAnd(600000000,2147483647));
  }
}
