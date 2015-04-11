package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/4/4.
 */

//IV，如果前一个比后一个小，则是减法，V－I＝4
public class RomantoInteger {
  public int romanToInt(String s) {
    int pre = 0;//记录前一个数
    int sum = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      int tmp = getNum(s.charAt(i));
      if(tmp<pre)
        sum -= tmp;
      else
        sum += tmp;
      pre = tmp;
    }
    return sum;
  }

  public int getNum(char c) {
    int number = 0;
    switch (c) {
      case 'I':
        number = 1;
        break;
      case 'V':
        number = 5;
        break;
      case 'X':
        number = 10;
        break;
      case 'L':
        number = 50;
        break;
      case 'C':
        number = 100;
        break;
      case 'D':
        number = 500;
        break;
      case 'M':
        number = 1000;
        break;
    }
    return number;
  }

  public static void main(String[] args){
    RomantoInteger r = new RomantoInteger();
    String a = "CDXXVII";
    System.out.println(r.romanToInt(a));
  }
}
