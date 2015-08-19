package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/19
 * Time: 下午9:34
 */
//Given an array of numbers nums,
// in which exactly two elements appear only once and all the other elements appear exactly twice.
// Find the two elements that appear only once.
//
//    For example:
//
//    Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//    Note:
//    The order of the result is not important. So in the above example, [5, 3] is also correct.
//    Your algorithm should run in linear runtime complexity.
// Could you implement it using only constant space complexity?
public class SingleNumber3 {
  public int[] singleNumber(int[] nums) {
    if (nums == null || nums.length < 1) {
      return null;
    }
    int[] number = {0, 0};
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }

    int pos = 0;
    while (result != 0) {
      if ((result & 1) == 0) {
        result = result >> 1;
        pos++;
      } else {
        break;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      int tmp = nums[i] >> pos;
      if ((tmp & 1) == 0)
        number[0] ^= nums[i];
      else
        number[1] ^= nums[i];
    }
    return number;

  }

  public static void main(String[] args) {
    SingleNumber3 s = new SingleNumber3();
    int[] nums = {-145417756, 744132272};
//    int[] nums = {43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
    int[] result = s.singleNumber(nums);
    for (int i : result) {
      System.out.println(i);
    }
  }
}
