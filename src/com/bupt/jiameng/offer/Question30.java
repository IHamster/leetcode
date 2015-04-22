package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/21
 * Time: 下午10:58
 */
//最小的K个数
public class Question30 {
  public int[] getLeastNumbers(int[] a,int k){
    if(a==null ||a.length<1 || k>a.length || k<1)
      return null;
    int start = 0;
    int end = a.length-1;
    int index = partition(a,start,end);
    while(index !=k-1){
      if(index>k-1){
        index = partition(a,start,index-1);
      }
      else{
        index = partition(a,index+1,end);
      }
    }
    int[] result = new int[k];
    for(int i =0;i<k;i++){
      result[i] = a[i];
    }
    return result;
  }

  public int partition(int[] a, int start, int end){
    if(start<end){
      int index1 = start;
      int index2 = end;
      while(index1<index2){
        while(index1<index2 && a[index2]>=a[index1])
          index2--;
        if(index1<index2){
          int tmp = a[index1];
          a[index1] = a[index2];
          a[index2] = tmp;
        }

        while(index1<index2 && a[index2]>a[index1])
          index1++;
        if(index1<index2){
          int tmp = a[index1];
          a[index1] = a[index2];
          a[index2] = tmp;
        }
      }
      for(int i:a){
        System.out.print(i + "->");
      }
      System.out.println();
      return index1;
    }
    return start;
  }

  public static void main(String[] args){
    Question30 q =new Question30();
    int[] a={4,5,1,6,2,7,3,3,8};
    int[] b = q.getLeastNumbers(a,4);
    for(int i:b)
      System.out.print(i+"->");
  }
}
