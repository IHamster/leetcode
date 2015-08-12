package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/11
 * Time: 下午8:56
 */

//Given an array of n integers where n > 1, nums,
//    return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//    Solve it without division and in O(n).
//
//    For example, given [1,2,3,4], return [24,12,8,6].
//
//    Follow up:
//    Could you solve it with constant space complexity?
// (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
public class ProductofArrayExceptSelf {
@Deprecated
  //solution one: division, i dont't know other method before this
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    result[0] = 1;
    for(int i = 1; i<nums.length;i++){
      result[i] = result[i-1]*nums[i-1];
    }

    int temp = 1;
    for(int i = nums.length-1; i>=0;i--){
      result[i] = result[i]*temp;
      temp *= nums[i];
    }
    return result;
  }

  public static void main(String[] args){
    ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
    String a = "";
    int[] nums = {0,0};
    int[] result = p.productExceptSelf(nums);
    for(int i: result){
      System.out.print(i + "->");
    }
  }
}
