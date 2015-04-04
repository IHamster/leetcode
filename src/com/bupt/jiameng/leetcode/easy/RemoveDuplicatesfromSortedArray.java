package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/4/4.
 */

//[1,2,3,3,3,4]-->[1,2]
public class RemoveDuplicatesfromSortedArray {
  public int removeDuplicates(int[] A) {
    if(A == null || A.length<1) return 0;
    if(A.length == 1) return 1;

    int i=0,j=1;
    while(j<A.length){
      if(A[i] != A[j]){
        A[i+1] = A[j];
        i++;
      }
      j++;
    }

    return i+1;
  }

  public static void main(String[] args){
    RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
    int[] A = {1,1,2,3,3,3,4,5,6,7,8,8,9};
    System.out.println(r.removeDuplicates(A));
    for(int i:A)
      System.out.println(i);
  }
}
