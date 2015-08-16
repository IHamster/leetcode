package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/8/16
 * Time: 下午8:43
 */
//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//    Note:
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//    For example,
//    If nums = [1,2,2], a solution is:
//
//    [
//    [2],
//    [1],
//    [1,2,2],
//    [2,2],
//    [1,2],
//    []
//    ]
public class Subsets2 {
  private List<List<Integer>> result = new ArrayList<List<Integer>>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null || nums.length < 1) return result;
    Arrays.sort(nums);//先排序
    List<Integer> list = new ArrayList<Integer>();
    result.add(list);
    handler(nums, 0, list);
    return result;
  }

  private void handler(int[] nums, int start, List<Integer> list) {
    if (start == nums.length) return;

    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i] == nums[i-1])//主意这里的比较 ，nums[i] == nums[i-1]
        continue;
      list.add(nums[i]);
      result.add(new ArrayList<Integer>(list));
      handler(nums, i + 1, list);
      list.remove(list.size() - 1);

    }
  }

  public static void main(String[] args) {
    Subsets2 s = new Subsets2();
    int[] nums = {1, 2, 2};
    List<List<Integer>> result = s.subsetsWithDup(nums);
    for (List<Integer> list : result) {
      System.out.println(list.toString());
    }
  }
}
