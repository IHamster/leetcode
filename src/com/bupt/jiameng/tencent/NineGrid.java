package com.bupt.jiameng.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/9/8
 * Time: 下午5:12
 */
//有下图的题解，请列出满足下图0-100内的所有答案。
//[]+[]-9=4
// +  -  -
//[]-[]*[]=4
// /  *  -
//[]+[]-[]=4
//=4 =4 =4
public class NineGrid {
  List<List<Integer>> result = new ArrayList<List<Integer>>();

  public List<List<Integer>> getAnswer() {
    List<Integer> param = new ArrayList<Integer>(8);
    for (int i = 0; i < 8; i++) {
      param.add(0);
    }
    for (int i = 0; i <= 4; i++) {
      param.set(0, i);
      recursion(1, param);
    }
    return result;
  }

  /**
   * @param n 遍历到当前第几个数
   */
  public void recursion(int n, List<Integer> param) {
    if (n == 8) {
      if (param.get(5) != 0 && (param.get(0) + param.get(1) - 9 == 4) && (param.get(2) - param.get(3) * param.get(4) == 4) && (param.get(5) + param.get(6) - param.get(7) == 4)
          && (param.get(2) % param.get(5)==0) && (param.get(0) + param.get(2) / param.get(5) == 4) && (param.get(1) - param.get(3) * param.get(6) == 4) && (9 - param.get(4) - param.get(7) == 4)
          ) {
        List<Integer> tmp = new ArrayList<Integer>(param);
        result.add(tmp);

      }
      return;
    }
    if(n==4 || n == 7){
      for (int i = 0; i <= 5; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }else if(n==1){
      for (int i = 0; i <= 13; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }else if(n ==2){
      for (int i = 0; i <= 13; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }else if(n==3 || n==6){
      for (int i = 0; i <= 9; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }else if(n ==5){
      for (int i = 0; i <= 5; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }else{
      for (int i = 0; i <= 100; i++) {
        param.set(n, i);
        recursion(n + 1, param);
      }
    }

  }

  public static void main(String[] args) {
    NineGrid ng = new NineGrid();
    ng.getAnswer();
    for (List<Integer> list : ng.result) {
      System.out.println(list.toString());
    }
  }
}
