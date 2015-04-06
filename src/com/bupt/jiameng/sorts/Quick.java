package com.bupt.jiameng.sorts;

/**
 * User: jiameng
 * Date: 15/4/5
 * Time: 上午12:42
 */
//快速排序
  //5,6,9,7,8
public class Quick {
  public void sort(int[] a) {

  }

  public void recursion(int[] a, int index1, int index2) {
    if (index1 < index2) {
      int i = index1, j = index2, x = a[index1];

      while(i<j){

        while(i<j && a[j]>=x)
          j--;
        if(i<j){
          a[i]=a[j];
          i++;
        }

        while(i<j && a[i]<x)
          i++;
        if(i<j){
          a[j]=a[i];
          j--;
        }
      }
      a[i] = x;
      recursion(a,index1,i-1);
      recursion(a, i+1,index2);
    }
  }

  public static void main(String[] args){
    Quick q = new Quick();
    int[] a = {5,6,9,7,8};
    q.recursion(a,0,a.length-1);
    for(int i: a)
      System.out.print(i);
  }
}
