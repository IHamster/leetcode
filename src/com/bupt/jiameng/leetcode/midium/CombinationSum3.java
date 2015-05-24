package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/5/25
 * Time: 上午12:53
 */
//Find all possible combinations of k numbers that add up to a number n,
// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//    Ensure that numbers within the set are sorted in ascending order.
//
//
//    Example 1:
//
//    Input: k = 3, n = 7
//
//    Output:
//
//    [[1,2,4]]
//
//    Example 2:
//
//    Input: k = 3, n = 9
//
//    Output:
//
//    [[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSum3 {
  List<List<Integer>> result = new ArrayList<List<Integer>>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    recursion(k,0,0,1,n, new ArrayList<Integer>());
    return result;
  }

  public void recursion(int k, int count, int sum, int start, int target, List<Integer> list) {
    if (sum == target && count == k) {
      List<Integer> tmp = new ArrayList<Integer>(list);
      result.add(tmp);
      return;
    }
    if (sum > target || count > k)
      return;
    for (int i = start; i < 10; i++) {
      List<Integer> tmp = new ArrayList<Integer>(list);
      tmp.add(i);
      recursion(k, count+1, sum + i, i+1, target, tmp);
    }
  }

  public static void main(String[] args){
    CombinationSum3 c = new CombinationSum3();
    c.combinationSum3(3, 9);
    for(List<Integer> list: c.result)
      System.out.println("result="+list.toString());
  }
}
