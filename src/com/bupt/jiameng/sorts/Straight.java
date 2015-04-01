package com.bupt.jiameng.sorts;

/**
 * Created by jiameng on 15/4/1.
 */

//直接插入排序
public class Straight {
  public void sort(int[] a) {
    if (a == null || a.length < 1) return;

    int length = a.length;
    for (int i = 1; i < length; i++) {
      int tmp = a[i];
      int j;
      for(j= i-1;j>=0 && a[j]>tmp;j--){
        a[j+1] = a[j];
      }
      a[j+1] = tmp;
    }
  }

  public static void main(String[] args){
    Straight s = new Straight();
    int[] a = {18,8,56,9,68,8};
    s.sort(a);
    for(int i : a){
      System.out.println(i);
    }
  }
}
