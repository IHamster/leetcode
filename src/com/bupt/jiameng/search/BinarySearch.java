package com.bupt.jiameng.search;

/**
 * User: jiameng
 * Date: 15/4/26
 * Time: 上午12:00
 */
//二分查找
public class BinarySearch {
  public boolean binSearch(int[] nums,int k, int start, int end){
    if(start>end)
      return false;

    int mid = (start+end)/2;
    if(nums[mid] == k)
      return true;
    else if(nums[mid]>k)
      return binSearch(nums,k,start,mid-1);
    else
      return binSearch(nums,k,mid+1,end);
  }

  public static void main(String[] args){
    BinarySearch bs = new BinarySearch();
    int[] a = {1,2,3,3,3,3,4,5,6,6,7};
    System.out.println(bs.binSearch(a,5,0,a.length-1));
  }
}
