package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/10
 * Time: 下午8:33
 */
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if(x < 0) return false;
    if(x < 10) return true;

    int sum = 0;
    int tmp = x;
    while(tmp >0){
      sum  = sum*10 + tmp%10;
      tmp = tmp/10;
    }

    if(sum == x)
      return true;
    else return false;
  }

  public static void main(String[] args){
    PalindromeNumber p = new PalindromeNumber();
    int a = 122222211;
    System.out.println(p.isPalindrome(a));
  }
}
