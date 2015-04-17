package com.bupt.jiameng.contructs;

/**
 * User: jiameng
 * Date: 15/4/17
 * Time: 下午11:46
 */
public class ComplexListNode {
  public int val;
  public ComplexListNode next;
  public ComplexListNode sibling;

  public ComplexListNode(int x) {
    val = x;
    next = null;
    sibling = null;
  }
}
