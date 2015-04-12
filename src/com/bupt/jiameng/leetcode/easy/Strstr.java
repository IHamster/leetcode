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


  public int kmp(String haystack, String needle) {
    int i = 0;
    int j = 0;
    int hLen = haystack.length();
    int nLen = needle.length();
    int[] next = getNext(needle);
    while (i < hLen && j < nLen) {
      if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }

    if (j == nLen)
      return i - j;
    else
      return -1;
  }

  public int[] getNext(String needle) {
    int nLen = needle.length();
    int[] next = new int[nLen];

    next[0]=-1;
    int k = -1;
    int j=0;
    while(j<nLen-1){
      if(k==-1 || needle.charAt(j)==needle.charAt(k)){
        ++k;
        ++j;
        next[j]=k;
      }else{
        k=next[k];
      }
    }

    return next;
  }

  public static void main(String[] args) {
    Strstr s = new Strstr();
    String a = "abnnnfnfnfg";
    String p = "fnf";

  }
}