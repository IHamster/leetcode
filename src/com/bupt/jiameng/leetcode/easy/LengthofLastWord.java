package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/3/29.
 */
public class LengthofLastWord {
  public int lengthOfLastWord(String s) {
//    String[] words = s.split(" ");
//    if(words.length == 0)
//      return 0;
//    return words[words.length-1].length();
    if(s.length() < 1) return 0;
    int length = 0;
    int i =0;
    while(i<s.length()){
      if(s.charAt(i) == ' '){
        i++;
        continue;
      }
      else{
        if(i>0 && s.charAt(i-1) == ' '){
          length = 0;
          length++;
        }else{
          length++;
        }

      }
      i++;
    }

    return length;
  }

  public static void main(String[] args){
    LengthofLastWord l = new LengthofLastWord();
    String a = " qw";
    System.out.println(l.lengthOfLastWord(a));
  }
}
