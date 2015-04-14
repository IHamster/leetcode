package com.bupt.jiameng.leetcode.midium;

import java.util.HashMap;

/**
 * User: jiameng
 * Date: 15/4/14
 * Time: 上午12:01
 */
//Input: numbers={2, 7, 11, 15}, target=9
//    Output: index1=1, index2=2
//  tags:array | hash table
public class TwoSum {
  public int[] twoSum(int[] numbers, int target) {
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    int[] index = new int[2];

    for(int i=0;i<numbers.length;i++){
      if((map.get(target-numbers[i])!=null)  ){
        index[0]=1+ (i>map.get(target-numbers[i])?map.get(target-numbers[i]):i);
        index[1]=1+ (i<map.get(target-numbers[i])?map.get(target-numbers[i]):i);
        break;
      }else{
        map.put(numbers[i],i);
      }
    }

    return index;
  }

  public static void main(String[] args){
    TwoSum t=new TwoSum();
    int[] test = {0,4,3,0};
    int[] index=t.twoSum(test,0);
    for(int i:index)
      System.out.println(i);
  }


}
