package com.bupt.jiameng.leetcode.midium;

import java.util.*;

/**
 * User: jiameng
 * Date: 15/8/13
 * Time: 上午12:42
 */

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
// for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//    For example,
//
//    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//    Return:
//    ["AAAAACCCCC", "CCCCCAAAAA"].
public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<String>();
    if (s == null || s.length() < 10) return result;

    Set<String> set = new HashSet<String>();

    for (int i = 0; i < s.length() - 9; i++) {
      String tmp = s.substring(i, i + 10);
      if (!set.add(tmp)) {
        if(!result.contains(tmp))
          result.add(tmp);
      }
    }
    return result;
  }

  public static void main(String[] args){
    RepeatedDNASequences r = new RepeatedDNASequences();
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    String s1 = "AAAAAAAAAAAA";
    List<String> result = r.findRepeatedDnaSequences(s1);
    for(String str: result){
      System.out.println(str);
    }
  }
}
