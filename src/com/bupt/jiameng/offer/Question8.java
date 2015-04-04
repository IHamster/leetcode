package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/4
 * Time: 下午11:11
 */
//旋转数组的最小数字
//  ［3，4，5，1，2］ return 1
public class Question8 {
  public int min(int[] a){
    if(a == null || a.length <1) return -1;

    int index1 = 0;
    int index2 = a.length-1;
    int indexMid = index1;

    while(a[index1] >= a[index2]){
      if(index2-index1 ==1){
        indexMid = index2;
        break;
      }
      indexMid = (index1+index2)/2;

      if(a[index1] == a[index2] && a[index1] == a[indexMid])
        return minInOrder(a, index1,index2);
      if(a[indexMid]>=a[index1]){
        index1 = indexMid;
      }else{
        index2 = indexMid;
      }
    }
    return a[indexMid];
  }

  public int minInOrder(int[] a, int index1, int index2){
    int result = a[index1];
    for(int i=index1+1;i<=index2; i++){
      if(result>a[i])
        result=a[i];
    }
    return result;
  }

  public static void main(String[] args){
    Question8 q = new Question8();
//    int[] a = {3,4,5,1,1,2,2};
//    int[] a = {1,1,1,0,1,1,1};
    int[] a = {1};
    System.out.println(q.min(a));
  }

}
