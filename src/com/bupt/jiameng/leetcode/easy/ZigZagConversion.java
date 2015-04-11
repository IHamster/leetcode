package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/10
 * Time: 下午9:11
 */
public class ZigZagConversion {
  public String convert(String s, int nRows) {
    if(s == null || s.length()<1 || nRows < 1) return s;
    if(nRows == 1) return s;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <s.length() && i< nRows; i++) {
      int index = i;
      sb.append(s.charAt(index));
      for(int j = 1; index< s.length();j++){
        if(i == 0 || i == nRows-1){//第一行和最后一行的情况
          index += 2*nRows-2;
        }else{
          if(j %2!=0)
            index += 2*(nRows-1-i);
          else index +=2*i;
        }
        if(index< s.length())
          sb.append(s.charAt(index));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args){
    ZigZagConversion z = new ZigZagConversion();
    String a = "0123456789";
    System.out.println(z.convert(a,3));
  }
}
