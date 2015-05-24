package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/5/24
 * Time: 下午4:20
 */
//Given a set of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//    The same repeated number may be chosen from C unlimited number of times.
//
//    Note:
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//    For example, given candidate set 2,3,6,7 and target 7,
//    A solution set is:
//    [7]
//    [2, 2, 3]


  // 回溯算法
//http://blog.csdn.net/xiaobaohe/article/details/7897966   这个帖子最后一个图画错了
//  应该每次都存储一个当前数组的指针，然后每次遍历，从这个指针开始，防止重复
public class CombinationSum {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    recursion(candidates,0,0,target, new ArrayList<Integer>());
    return result;
  }

  public void recursion(int[] candidates,int curIndex,int sum,int target, List<Integer> list){
    if(sum == target){
      List<Integer> tmp = new ArrayList<Integer>(list);
      result.add(tmp);
      return;
    }
    if(sum > target)
      return;
    for(int i = curIndex;i<candidates.length;i++){
      List<Integer> tmp  = new ArrayList<Integer>(list);
      tmp.add(candidates[i]);
      recursion(candidates, i,sum + candidates[i],target,tmp);

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
    CombinationSum c = new CombinationSum();
    int[] a = {2,3,6,7};
    c.combinationSum(a,7);
    for(List<Integer> list: c.result)
      System.out.println(list.toString());
  }
}
