package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/11
 * Time: 下午8:09
 */

////Write a function that takes an unsigned integer and returns the number of ’1' bits it has
// (also known as the Hamming weight).
//    For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
// so the function should return 3.
public class Numberof1Bits {
  // you need to treat n as an unsigned value
//  注意是无符号数，如果是有符号的数，可以用（n-1)&n
  public int hammingWeight(int n) {
    int count = 0;

    while(n!=0){
      if((n&1) == 1)
        count++;
      n = n>>>1;
    }
    return count;
  }

  public static void main(String[] args){
    Numberof1Bits n = new Numberof1Bits();
    int a = -1;
    System.out.println(n.hammingWeight(a));
  }
}
