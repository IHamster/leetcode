package com.bupt.jiameng.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jiameng
 * Date: 15/9/8
 * Time: 下午12:15
 */
public class GrayCode {
  List<Integer> result = new ArrayList<Integer>();

  public List<Integer> grayCode(int n) {
    if (n < 0) return result;
    if (n == 0) {
      recursion(0, n - 1);
    } else {
      recursion(0, n - 1);
      recursion(1, n - 1);
    }
    return result;
  }

  //下面的递归实际只是递归的计数而已，num^(num>>1)才是求格雷码的，所以这个递归没啥用，貌似
  public void recursion(int num, int n) {
    if (n <= 0) {
      result.add(num ^ (num >> 1));
      return;
    }

    int tmp1 = num << 1;
    recursion(tmp1, n - 1);
    int tmp2 = (num << 1) | 1;
    recursion(tmp2, n - 1);
  }

  public List<Integer> grayCode2(int n) {
    List<Integer> result = new ArrayList<Integer>();
    if (n < 0) return result;

    if(n == 0){
      result.add(0);
      return result;
    }
    if (n == 1) {
      result.add(0);
      result.add(1);
      return result;
    }

    List<Integer> last = grayCode2(n - 1);

    int length = last.size();
    int mask = 1<<n-1;
    for (int i = 0; i < length; i++) {
      result.add(last.get(i));//顺序加0操作,
    }
    for (int i = length-1; i >=0; i--) {
      result.add(last.get(i)|mask);//逆序加1操作,
    }
    return result;
  }

  public static void main(String[] args) {
    GrayCode gg = new GrayCode();
//    gg.grayCode(0);
    List<Integer> result = gg.grayCode2(3);
    System.out.println(result.toString());
  }
}
