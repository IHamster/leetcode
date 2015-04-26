package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/26
 * Time: 下午10:55
 */
//左旋转字符串
//  把字符串前面的若干字符转移到字符串的尾部。
//  例如输入：abcdef，2；输出：cdefab
public class Question42_2 {
  public void leftRotateString(char[] chars, int k) {
    if (chars == null || chars.length < 1 || k < 0 || k > chars.length)
      return;

    reverse(chars, 0, chars.length - 1);
    reverse(chars, 0, chars.length - 1 - k);
    reverse(chars, chars.length - k, chars.length - 1);

  }

  public void reverse(char[] chars, int index1, int index2) {
    while (index1 < index2) {
      char tmp = chars[index1];
      chars[index1] = chars[index2];
      chars[index2] = tmp;
      index1++;
      index2--;
    }
  }

  public static void main(String[] args) {
    Question42_2 q = new Question42_2();
    char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    q.leftRotateString(a, 8);
    for (char c : a)
      System.out.print(c + "->");
  }
}
