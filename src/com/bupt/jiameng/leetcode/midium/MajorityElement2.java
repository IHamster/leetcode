package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.java_test.threads.InterruptedDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/8/18
 * Time: 下午10:43
 */
//Given an integer array of size n,
// find all elements that appear more than ⌊ n/3 ⌋ times.
// The algorithm should run in linear time and in O(1) space.
//自行百度摩尔投票法
//思路:1,   超过n/3的元素个数最多两个
//
//    2,   数组中连续3个数据为一组的话,一共n/3组,那么如果存在符合条件的元素,这个元素一定出现在某一个组内两次
//
//    3,   知道了以上两个条件后,用所谓的摩尔投票法,共两轮,
//
//    第一轮:找出出现次数最多的两个元素,每次存储两个元素n1和n2,如果第三个元素与其中一个相同,则增加计数cn1或cn2,  否则,清除n1和n2,从下一个数据开始重新统计.
//
//    根据第二条,数目较多的元素一定可以被查到,当然查到的不一定是大于n/3的.
//
//    第二轮:验证这两个元素是否满足条件,即出现的次数是否大于n/3;
public class MajorityElement2 {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<Integer>();
    if (nums == null || nums.length < 1) return result;

    int num1 = 0;
    int num2 = 0;
    int count1 = 0;
    int count2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num1) {
        count1++;
      } else if (nums[i] == num2) {
        count2++;
      } else if (count1 == 0) {
        num1 = nums[i];
        count1++;
      } else if (count2 == 0) {
        num2 = nums[i];
        count2++;
      }else{
        count1--;
        count2--;
      }
    }
    if(num1 == num2) num2--;
    count1 = 0; count2 =0;
    for(int i = 0;i<nums.length;i++){
      if(num1 == nums[i]) count1++;
      if(num2 == nums[i]) count2++;
    }
    if(count1>nums.length/3) result.add(num1);
    if(count2>nums.length/3) result.add(num2);
    return result;
  }

  public static void main(String[] args){
    MajorityElement2 m = new MajorityElement2();
    int[] nums = {0,0};
    List<Integer> list = m.majorityElement(nums);
    for(int i: list){
      System.out.println(i);
    }
  }
}

