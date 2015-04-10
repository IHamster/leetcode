package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/9
 * Time: 下午10:54
 */
public class StringtoInteger {
  public int atoi(String str) {
    if(str == null || str.length()<1) return 0;

    long sum = 0;
    int i = 0;//首个不为空的字符
    int sign   = 1;

    while(i<str.length()){
      if(str.charAt(i) == ' ') i++;
      else break;
    }

    if(i<str.length() && str.charAt(i) == '+') {
      sign= 1;
      i++;
    }else if(i<str.length() && str.charAt(i) == '-'){
      sign=-1;
      i++;
    }

    for(int j = i;j<str.length();j++){
      if(str.charAt(j) >='0' && str.charAt(j) <='9'){
        sum = sum*10 + (str.charAt(j)-'0');
        if (sum > Integer.MAX_VALUE) break;
      }
      else break;
    }

    if(sum*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    else if(sum*sign<Integer.MIN_VALUE ) return Integer.MIN_VALUE;
    else return (int)sum*sign;
  }

  public static void main(String[] args){
    StringtoInteger s = new StringtoInteger();
    String a = "9223372036854775809";
    System.out.println(s.atoi(a));
  }
}
