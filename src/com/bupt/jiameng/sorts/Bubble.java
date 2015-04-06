package com.bupt.jiameng.sorts;

/**
 * User: jiameng
 * Date: 15/4/6
 * Time: 下午8:37
 */
//bubble sort
public class Bubble {
  public void sort(int[] a) {
    int length = a.length;

    for (int i = length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j]>a[j+1]) {
          a[j] = a[j] ^ a[j +1];
          a[j+1] = a[j]^a[j+1];
          a[j] = a[j]^a[j+1];
        }

      }
    }
  }

  public static void main(String[] args){
    Bubble b = new Bubble();
    int[] a = {18,8,15,9,5,3,8,1};
    b.sort(a);
    for(int i:a)
      System.out.println(i);
  }

}
