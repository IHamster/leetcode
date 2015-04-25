package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/25
 * Time: 下午11:16
 */
//数字在排序数组中出现的次数
//  例：输入｛1，2，3，3，3，3，4，5｝和3，输出4
public class Question38 {
  public int getFirstK(int[] nums,int k,int start,int end){
    if(start > end)
      return -1;
    int mid = (start+end)/2;
    int tmp = nums[mid];
    if(tmp == k){
      if(mid == 0 || (mid > 0 && nums[mid-1]<k))
        return mid;
      else
        return getFirstK(nums,k,start,mid-1);
    }else if(tmp > k){
      return getFirstK(nums,k,start,mid-1);
    }else{
      return getFirstK(nums,k,mid+1,end);
    }
  }

  public int getLastK(int[] nums,int k,int start,int end){
    if(start > end)
      return -1;
    int mid = (start+end)/2;
    int tmp = nums[mid];
    if(tmp == k){
      if(mid == nums.length-1 || (mid <(nums.length-1) && nums[mid+1]>k))
        return mid;
      else
        return getLastK(nums, k, mid + 1, end);
    }else if(tmp > k){
      return getLastK(nums, k, start, mid - 1);
    }else{
      return getLastK(nums, k, mid + 1, end);
    }
  }

  public int getNumberOfK(int[] nums,int k){
    if(nums == null || nums.length<1)
      return 0;
    int first = getFirstK(nums,k,0,nums.length-1);
    int last = getLastK(nums,k,0,nums.length-1);

    if(first>-1 && last>-1)
      return last-first+1;
    return 0;
  }

  public static void main(String[] args){
    Question38 q = new Question38();
    int[] a ={1,2,3,3,3,3,4,5};
    System.out.println(q.getNumberOfK(a,4));
  }
}
