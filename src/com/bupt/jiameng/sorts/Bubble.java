package com.bupt.jiameng.sorts;

/**
 * User: jiameng
 * Date: 15/4/6
 * Time: 下午8:37
 */
//bubble sort
public class Bubble {
  public void sort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for(int j=a.length-1;j>i;j--){
        if(a[j]<a[j-1]){
          swap(a,j,j-1);
        }
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    Bubble b = new Bubble();
    int[] a = {18, 8, 15, 9, 5, 3, 8, 1};
    b.sort(a);
    for (int i : a)
      System.out.println(i);
  }

}
