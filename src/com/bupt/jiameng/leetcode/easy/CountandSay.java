package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/3/29.
 */
//The count-and-say sequence is the sequence of integers beginning as follows:
//    1, 11, 21, 1211, 111221, ...
//
//    1 is read off as "one 1" or 11.
//    11 is read off as "two 1s" or 21.
//    21 is read off as "one 2, then one 1" or 1211.
//    Given an integer n, generate the nth sequence.
//
//    Note: The sequence of integers will be represented as a string
public class CountandSay {
  public String countAndSay(int n) {
    StringBuffer fi = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      if(i ==1)
        fi.append(1);
      else{
        int count = 0;
        char cur = fi.charAt(0);
        StringBuffer sb = new StringBuffer();
        for(int j =0;j<fi.length();j++){
          if(cur != fi.charAt(j)){
            sb.append(count).append(cur);
            cur = fi.charAt(j);
            count = 1;
          }else count++;
        }
        sb.append(count).append(cur);
        fi = sb;
      }
    }
    return fi.toString();
  }

  public static void main(String[] args) {
    CountandSay c = new CountandSay();
    int a = 6;
    System.out.println(c.countAndSay(a));
  }
}
