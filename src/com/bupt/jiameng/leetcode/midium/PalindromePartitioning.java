package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/5/8
 * Time: 下午11:31
 */
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();

    if(s == null || s.length()<1) return result;
    return recursion(s,result,new ArrayList<String>());
  }

  public List<List<String>> recursion(String s,List<List<String>> result,List<String> list){
    if(s.length()<1){
      result.add(list);
      return result;
    }
    for(int i=0;i<s.length();i++){
      if(isPalindrome(s.substring(0, i + 1))){
        List<String> newList = new ArrayList<String>(list);
        newList.add(s.substring(0, i +1));
        result = recursion(s.substring(i+1),result,newList);
      }
    }
    return result;
  }

  public boolean isPalindrome(String s){
    int start = 0;
    int end = s.length()-1;
    while(start<end){
      if(s.charAt(start) != s.charAt(end))
        return false;
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args){
    PalindromePartitioning pp = new PalindromePartitioning();
    String a = "cbbbcc";
    List<List<String>> result = pp.partition(a);
    for(List<String> list: result){
      System.out.println(list);
    }
  }
}
