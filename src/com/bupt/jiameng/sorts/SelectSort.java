package com.bupt.jiameng.sorts;

/**
 * User: jiameng
 * Date: 15/6/1
 * Time: 下午10:51
 */
//简单选择排序
public class SelectSort {
  public void sort(int[] nums){
    if(nums == null || nums.length<1) return;

    for(int i = 0;i<nums.length-1;i++){
      int min = i;
      for(int j = i+1;j<nums.length;j++){
        if(nums[min]>nums[j])
          min = j;
      }
      if(min!=i)
        swap(nums,min,i);
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    SelectSort b = new SelectSort();
    int[] a = {18, 8, 15, 9, 5, 3, 8, 1};
    b.sort(a);
    for (int i : a)
      System.out.println(i);
  }
}
