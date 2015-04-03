package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/4/3.
 */
public class Strstr {
  //a,d,
  //d,f
  //掌握kmp算法！！！！！！

  public int strStr(String haystack, String needle) {
    int plength = needle.length();
    int hlength = haystack.length();
    if (plength > hlength)
      return -1;
    int i = 0;
    int j = 0;
    while (i < hlength) {
      while (j < plength) {
        if (haystack.charAt(j + i) != needle.charAt(j)) {
          j = 0;
          break;
        } else {
          j++;
        }
      }
      if (j == plength) {
        break;
      } else {
        i++;
        if (hlength - i < plength) {
          i = -1;
          break;
        }
      }
    }

    return i;
  }
}
