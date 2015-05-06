package com.bupt.jiameng.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/4/28
 * Time: 下午11:04
 */
public class Sum3 {
  public List<List<Integer>> threeSum(int[] num) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if (num == null || num.length < 1)
      return result;
    Arrays.sort(num);
    for(int i: num)
      System.out.println(i+"->");
    for(int i =0;i<num.length-2;i++){
      if(i>0 && num[i] == num[i-1])
        continue;
      System.out.println("test");
      List<List<Integer>> tmp = sum2(num,(0-num[i]),i+1,(num.length-1));
      if(tmp.size()>0){
        for(List t:tmp){
          t.add(num[i]);
          Collections.sort(t);
        }
        result.addAll(tmp);
      }
    }

    return result;
  }

  public List<List<Integer>> sum2(int[] num,int target, int start, int end){
    int index1 = start;
    int index2 = end;
    int sum = 0;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    while(index1<index2){
      if(index1>start && num[index1] == num[index1-1]){
        index1++;
        continue;
      }
      if(index2<end && num[index2] == num[index2+1]){
        index2--;
        continue;
      }
      sum = num[index1]+num[index2];
      System.out.println(sum);
      if(sum ==  target){
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(num[index1]);
        tmp.add(num[index2]);
        list.add(tmp);
        index1++;
        index2--;
      }else if(sum < target){

        index1++;
      }else
        index2--;
    }
    System.out.println("111");

    return list;
  }

  public static void main(String[] args){
    Sum3 s = new Sum3();
    int[] a = {0,1,-1};
    s.threeSum(a);
  }
}
