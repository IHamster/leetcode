package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/22
 * Time: 下午10:53
 */
//连续子数组的最大和
//  输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
//  求所有子数组的和的最大值。要求时间复杂度为o(n)
public class Question31 {

  //解法1
  public int findGreatestSumOfSubArray(int[] nums) {
    if (nums == null || nums.length < 1)
      return 0;
    int curSum = nums[0];
    int preMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (curSum < 0) {
        curSum = nums[i];
      } else {
        curSum += nums[i];
      }
      if (curSum > preMax) {
        preMax = curSum;
      }
    }
    return preMax > curSum ? preMax : curSum;
  }

  public static void main(String[] args) {
    Question31 q = new Question31();
//    int[] a ={1,-2,3,10,-4,7,2,-5};
    int[] a = {-1,-2,-3,-4,-5};
//    int[] a = {1, 2, 3, 4, 5};
    System.out.println(q.findGreatestSumOfSubArray(a));
  }
}
