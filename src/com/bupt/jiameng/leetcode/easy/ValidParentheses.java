package com.bupt.jiameng.leetcode.easy;

import java.util.Stack;

/**
 * Created by jiameng on 15/4/4.
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s == null || s.length() < 1) return true;
    if (s.length() % 2 != 0) return false;

    Stack<Character> stack = new Stack<Character>();
    stack.push(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if(stack.empty()){
        stack.push(s.charAt(i));
        continue;
      }
      char tmp = stack.peek();
      switch (tmp) {
        case '(':
          if (s.charAt(i) == ')') {
            stack.pop();
          } else {
            stack.push(s.charAt(i));
          }
          break;
        case '[':
          if (s.charAt(i) == ']')
            stack.pop();
          else
            stack.push(s.charAt(i));
          break;
        case '{':
          if (s.charAt(i) == '}')
            stack.pop();
          else
            stack.push(s.charAt(i));
          break;
        default:
          break;
      }
    }
    if(stack.empty())
      return true;
    else
      return false;
  }
}
