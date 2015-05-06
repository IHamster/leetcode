package com.bupt.jiameng.leetcode.midium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * User: jiameng
 * Date: 15/4/14
 * Time: 下午8:26
 */
//Given a string, find the length of the longest substring without repeating characters.
//    For example,
//    the longest substring without repeating letters for "abcabcbb" is "abc",
//    which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
//  tags: hash table| two pointer|String
public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() < 1) return 0;
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    int longest = 0;
    int index1 = 0, index2 = 0;
    int tmpLen=0;
    while(index1<s.length() && index2<s.length()){
      if(map.get(s.charAt(index2))==null){
        tmpLen++;
        map.put(s.charAt(index2), index2);
        index2++;
      }else{
        longest = Math.max(longest,tmpLen);
        int i = index1;
        for(;i<=index2;i++){
          if(s.charAt(i)!=s.charAt(index2)){
            map.remove(s.charAt(i));
            tmpLen--;
          }else{
            index2++;
            i++;
            break;
          }
        }
        index1 = i;
      }
    }
    longest = Math.max(longest,tmpLen);
    return longest;
  }

//  public int lengthOfLongestSubstring(String s) {
//    if (s == null || s.length() < 1) return 0;
//
//    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//    int longest = 0;
//    int index1 = 0, index2 = 0;
//    int tmpLen=0;
//    while(index2<s.length()){
//      if(map.get(s.charAt(index2))==null){
//        tmpLen++;
////        System.out.println("put"+s.charAt(index2));
//        map.put(s.charAt(index2), index2);
//        index2++;
//      }else{
//        longest = Math.max(longest,tmpLen);
//        while(s.charAt(index1)!= s.charAt(index2)) {
//          map.remove(s.charAt(index1));
//          //新候选字串从第一个重复字符(当s[i] == s[j]时候的i)的后一位开始算，之前的i不算，等效于没有被扫描到，所以设为false.
//          index1++;
//        }
//        index1++;
//        index2++;
//      }
//      longest = longest > (index2-index1) ? longest : (index2-index1);
//    }
//    return longest;
//  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    String a = "b";
    System.out.println(l.lengthOfLongestSubstring(a));
  }
}
