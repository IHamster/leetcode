package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/11
 * Time: 下午4:56
 */
//Reverse bits of a given 32 bits unsigned integer.
//
//    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
//    return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//    Follow up:
//    If this function is called many times, how would you optimize it?

public class ReverseBits {
  // you need treat n as an unsigned value
//  java里只要返回的数的二进制是之前的倒叙就可以
  public int reverseBits(int n) {
    int tmp = 0;

    for(int i =0;i<32; i++){
      tmp = (tmp<<1) + (n&1);
      n = n>>1;
    }
    return tmp;
  }


  public static void main(String[] args){
    ReverseBits r = new ReverseBits();
    int a = 1;
    System.out.println(r.reverseBits(a));
  }
}
