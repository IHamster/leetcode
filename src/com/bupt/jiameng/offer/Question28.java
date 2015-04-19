package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/19
 * Time: 下午8:46
 */
//字符串的排列
//  输入一个字符串，打印出该字符串中字符的所有排列。
//  例如，输入abc，输出abc,acb,bac,bca,cab,cba
public class Question28 {
  public void permutation(char[] c) {
    if (c == null || c.length < 1) return;
    recursion(c, 0);
  }

  public void recursion(char[] c, int start) {
    if (start == c.length - 1) {
      for (char i : c) {
        System.out.print(i);
      }
      System.out.println();
      return;
    }

    for (int i = start; i < c.length; i++) {
      if (i > start && c[start] == c[i]) continue;
      char tmp = c[start];
      c[start] = c[i];
      c[i] = tmp;
      recursion(c, start + 1);
//      tmp = c[start];
//      c[start]=c[i];
//      c[i]=tmp;//使数组恢复原状
    }
  }

  public static void main(String[] args) {
    Question28 q = new Question28();
    char[] c = {'a', 'b', 'c'};
    q.permutation(c);
    for(char i: c)
      System.out.println(i);
  }
}
