package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/3
 * Time: 上午12:54
 */

//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//    Your algorithm's runtime complexity must be in the order of O(log n).
//
//    If the target is not found in the array, return [-1, -1].
//
//    For example,
//    Given [5, 7, 7, 8, 8, 10] and target value 8,
//    return [3, 4].
//[5, 7, 7, 8, 8, 8, 10]
public class SearchForARange {
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums == null || nums.length < 1 || nums[0] > target || nums[nums.length - 1] < target)
      return result;
    binarySearch(nums, target, result, 0, nums.length-1);
    return result;
  }

  private void binarySearch(int[] nums, int target, int[] result, int start, int end) {
    if (start > end)
      return;
    int mid = (start + end) / 2;
    if(nums[mid] > target){
      binarySearch(nums, target, result, start, mid-1);
    }else if(nums[mid] < target){
      binarySearch(nums, target, result, mid + 1, end);
    }else if(nums[mid] == target){
      if(result[0]== -1 || result[0]>mid ){
        result[0] = mid;
      }
      if(result[1]<mid){
        result[1]= mid;
      }
      if((mid-1)>=0 && nums[mid-1] == target)
        binarySearch(nums, target, result, start, mid-1);
      if((mid+1)<=(nums.length-1) && nums[mid+1] == target)
        binarySearch(nums, target, result, mid+1, end);
    }
  }

  public static void main(String[] args){
    SearchForARange s=  new SearchForARange();
//    int[] nums = {5, 7, 8, 8, 8, 10};
    int[] nums = {9,9};
    int[] result = s.searchRange(nums,9);
    for(int i: result)
      System.out.println(i);
  }
}
