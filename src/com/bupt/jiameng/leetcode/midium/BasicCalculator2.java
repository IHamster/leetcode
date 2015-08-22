package com.bupt.jiameng.leetcode.midium;

import java.util.Stack;

/**
 * User: jiameng
 * Date: 15/8/20
 * Time: 下午9:58
 */
//Implement a basic calculator to evaluate a simple expression string.
//
//    The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
// The integer division should truncate toward zero.
//
//    You may assume that the given expression is always valid.
//
//    Some examples:
//    "3+2*2" = 7
//    " 3/2 " = 1
//    " 3+5 / 2 " = 5
//    Note: Do not use the eval built-in library function.
public class BasicCalculator2 {
  public int calculate(String s) {
    Stack<String> stack = new Stack<String>();

    int index = 0;
    boolean preIsMutiOrDev = false;
    while (index < s.length()) {
      while (index < s.length() && s.charAt(index) == ' ') {
        index++;
      }
      //是数字
      if (index > s.length() - 1) break;
      if (s.charAt(index) <= '9' && s.charAt(index) >= '0') {
        int end = index;
        while (end < s.length() && s.charAt(end) <= '9' && s.charAt(end) >= '0') {
          end++;
        }
        //如果前一个是乘法或者除法
        if (preIsMutiOrDev) {
          String op = stack.pop();
          String num1 = stack.pop();
          int tmpResult = calculate(num1, s.substring(index, end), op);
          stack.push(String.valueOf(tmpResult));
        } else {
          stack.push(s.substring(index, end));
        }
        index = end;
      } else {//是操作符
        stack.push(s.substring(index, index + 1));
        if (s.charAt(index) == '*' || s.charAt(index) == '/')
          preIsMutiOrDev = true;
        else {
          preIsMutiOrDev = false;
        }
        index++;
      }
    }
    while (stack.size() > 1) {
      int tmpResult = 0;
      String num2 = stack.pop();
      String op = stack.pop();
      String num1 = stack.pop();
      if(stack.size() > 1 && stack.peek().equals("-")){
        if(op.equals("-"))
          tmpResult= calculate(num1, num2, "+");
        else
          tmpResult= calculate(num1, num2, "-");
      }else{
        tmpResult = calculate(num1, num2, op);
      }
      stack.push(String.valueOf(tmpResult));
    }
    return Integer.parseInt(stack.pop());
  }

  private int calculate(String a, String b, String op) {
    int num1 = Integer.parseInt(a);
    int num2 = Integer.parseInt(b);
    int result = 0;
    if (op.equals("-")) {
      result = num1 - num2;
    } else if (op.equals("+")) {
      result = num1 + num2;
    } else if (op.equals("*")) {
      result = num1 * num2;
    } else if (op.equals("/")) {
      result = num1 / num2;
    }
    return result;
  }

  public static void main(String[] args) {
    BasicCalculator2 b = new BasicCalculator2();
    String s = "1-1+1";
    System.out.println(b.calculate(s));
  }
}
