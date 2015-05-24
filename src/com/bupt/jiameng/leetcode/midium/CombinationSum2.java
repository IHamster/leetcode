package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/5/24
 * Time: 下午9:22
 */
//Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//    Each number in C may only be used once in the combination.
//
//    Note:
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//    For example, given candidate set 10,1,2,7,6,1,5 and target 8,
//    A solution set is:
//    [1, 7]
//    [1, 2, 5]
//    [2, 6]
//    [1, 1, 6]
public class CombinationSum2 {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    recursion(candidates,0,0,target, new ArrayList<Integer>());
    return result;
  }

  public void recursion(int[] candidates,int start, int sum,int target, List<Integer> list){
    if(sum == target){
      List<Integer> tmp = new ArrayList<Integer>(list);
      result.add(tmp);
      return;
    }
    if(sum > target)
      return;
    for(int i = start;i<candidates.length;i++){
      List<Integer> tmp  = new ArrayList<Integer>(list);
      tmp.add(candidates[i]);
      recursion(candidates, i+1,sum +  candidates[i],target,tmp);
      int j = i+1;
      while(j<candidates.length){
        if(candidates[j] == candidates[i]){
          ++j;
        }else {
          break;
        }
      }
      i=j-1;
    }
  }
  public static void main(String[] args){
    CombinationSum2 c = new CombinationSum2();
    int[] a = {1,1};
    c.combinationSum2(a, 1);
    for(List<Integer> list: c.result)
      System.out.println("result="+list.toString());
  }
}
