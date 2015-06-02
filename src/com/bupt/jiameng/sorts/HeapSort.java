package com.bupt.jiameng.sorts;

/**
 * User: jiameng
 * Date: 15/5/26
 * Time: 下午11:57
 */
public class HeapSort {
  public void heapSort(int[] nums) {
    if(nums == null || nums.length<1) return;

    for(int i = nums.length/2-1;i>=0;i--){
      heapAjust(nums,i,nums.length-1);
    }

    for(int i = nums.length-1;i>=1;i--){
      swap(nums,0,i);
      heapAjust(nums,0,i-1);
    }
  }

  public void heapAjust(int[] nums, int start, int end){

    int tmp = nums[start];
    for(int i = start*2+1;i<=end;i=i*2+1){
      if(i<end && nums[i]<nums[i+1])
        i++;
      if(tmp>=nums[i])
        break;
      nums[start] = nums[i];
      start = i;
    }
    nums[start] = tmp;

  }


  public void swap(int[] nums, int index1, int index2) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }

  public static void main(String[] args) {
    HeapSort hp = new HeapSort();
    int[] a = {5, 1, 9, 3, 7, 4, 8, 6, 2};
    hp.heapSort(a);
    for(int i: a)
      System.out.printf(i+"->");
  }
}
