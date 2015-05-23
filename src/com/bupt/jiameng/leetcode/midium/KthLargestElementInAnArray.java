package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/5/23
 * Time: 下午5:53
 */

//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//    For example,
//    Given [3,2,1,5,6,4] and k = 2, return 5.
//
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ array's length.
public class KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    if(nums == null || nums.length<1) return 0;
    return partition(nums,k,0,nums.length-1);
  }

  public int partition(int[] nums,int k, int start, int end){
    if(start > end) return Integer.MIN_VALUE;

    int left = start;
    int right = end;
    while(left<right){
      while(left<right && nums[right]>=nums[left]){
        right--;
      }
      if(left<right){
        swap(nums, left,right);
      }

      while(left<right && nums[right]>=nums[left]){
        left++;
      }
      if(left<right){
        swap(nums, left,right);
      }
    }
    if((nums.length-k)==left)
      return nums[left];
    else if((nums.length-k)>left){
      return partition(nums,k,left+1,end);
    }else{
      return partition(nums,k,start,left-1);
    }

  }

  public void swap(int[] nums,int index1, int index2){
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }

  public static void main(String[] args){
    KthLargestElementInAnArray k = new KthLargestElementInAnArray();
    int[] a = {3,2,1,5,6,4};
    System.out.println(k.findKthLargest(a,3));
  }
}
