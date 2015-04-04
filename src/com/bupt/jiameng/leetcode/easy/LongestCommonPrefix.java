package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/4/4.
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length <1) return "";
    if(strs.length == 1) return strs[0];

    int longestLen = Integer.MAX_VALUE;

    for(int i = 0;i<strs.length-1;i++){
      int tmp = 0;
      for(int j=0;j<strs[i].length() && j< strs[i+1].length() && j<longestLen;j++){
        if(strs[i].charAt(j) == strs[i+1].charAt(j))
          tmp++;
        else
          break;
      }
      if(longestLen > tmp)
        longestLen = tmp;
    }

    return strs[0].substring(0,longestLen);
  }
}
