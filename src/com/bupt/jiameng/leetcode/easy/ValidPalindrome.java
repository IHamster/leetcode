package com.bupt.jiameng.leetcode.easy;

import java.util.Stack;

/**
 * Created by Administrator on 2015/3/8.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        s = s.toLowerCase();
        if(length < 2)
            return true;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                stack.push(s.charAt(i));
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if(s.charAt(i) == stack.pop())
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("race a car"));
    }
}
