package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.java_test.threads.InterruptedDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/8/12
 * Time: 下午8:19
 */

//Given a string of numbers and operators,
// return all possible results from computing all the different possible ways to group numbers and operators.
// The valid operators are +, - and *.
//
//
//    Example 1
//    Input: "2-1-1".
//
//    ((2-1)-1) = 0
//    (2-(1-1)) = 2
//    Output: [0, 2]
//
//
//    Example 2
//    Input: "2*3-4*5"
//
//    (2*(3-(4*5))) = -34
//    ((2*3)-(4*5)) = -14
//    ((2*(3-4))*5) = -10
//    (2*((3-4)*5)) = -10
//    (((2*3)-4)*5) = 10
//    Output: [-34, -14, -10, -10, 10]
public class DifferentWaystoAddParentheses {
  public List<Integer> diffWaysToCompute(String input) {
    if (input == null || input.length() < 1) return null;

    List<Integer> result = new ArrayList<Integer>();
//    if(input.length() ==1){
//      int num = input.charAt(0)-'0';
//      result.add(num);
//      return result;
//    }
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> left = diffWaysToCompute(input.substring(0,i));
        List<Integer> right = diffWaysToCompute(input.substring(i+1));
        for(int j = 0; j<left.size();j++){
          for(int k =0;k<right.size();k++){
            switch (c){
              case '+':
                result.add(left.get(j)+right.get(k));
                break;
              case '-':
                result.add(left.get(j)-right.get(k));
                break;
              case '*':
                result.add(left.get(j)*right.get(k));
                break;
              default:
                break;
            }
          }
        }
      }
    }
    if(result.isEmpty()){
      result.add(Integer.parseInt(input));
    }
    return result;
  }

  public static void main(String[] args){
    DifferentWaystoAddParentheses d = new DifferentWaystoAddParentheses();
    String s = "11";
    List<Integer> result = d.diffWaysToCompute(s);
    for(int i: result){
      System.out.print(i + "->");
    }
  }
}
