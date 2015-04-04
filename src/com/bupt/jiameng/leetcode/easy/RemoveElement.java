package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/4/3.
 */

//1,2,3,3,4----3
public class RemoveElement {
  public int removeElement(int[] A, int elem) {
    if(A==null || A.length<1) return 0;
    int i =0;
    int j=0;
    while(i<A.length){
      if(A[i] != elem){
        A[j]=A[i];
        j++;
      }
      i++;
    }
    return j;
  }

  public static void main(String[] args){
    RemoveElement r = new RemoveElement();
    int[] a = {4,5};
    System.out.println(r.removeElement(a,4));
    for(int i:a)
      System.out.println(i);
  }
}
