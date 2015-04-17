package com.bupt.jiameng.offer;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/4/15
 * Time: 下午9:33
 */
//合并两个排序的链表
public class Question17 {
  //普通的方法
  public ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode newHead = new ListNode(0);
    ListNode tmp = newHead;
    while (l1 != null && l2 != null) {
      if (l1.val >= l2.val) {
        tmp.next = l2;
        l2 = l2.next;
        tmp = tmp.next;
      } else {
        tmp.next = l1;
        l1 = l1.next;
        tmp = tmp.next;
      }
    }
    if (l1 == null) {
      tmp.next = l2;
    } else {
      tmp.next = l1;
    }
    return newHead.next;
  }

  public ListNode merge2(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode tmpHead = null;

    if (l1.val <= l2.val) {
      tmpHead = l1;
      tmpHead.next = merge2(l1.next, l2);

    } else {
      tmpHead = l2;
      tmpHead.next = merge2(l1, l2.next);
    }
    return tmpHead;
  }

  public static void main(String[] args) {
    Question17 q = new Question17();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);
    l1.next.next.next = new ListNode(7);
    l1.next.next.next.next = new ListNode(9);
    ListNode tmp = l1;
    while (tmp != null) {
      System.out.print(tmp.val + "->");
      tmp = tmp.next;
    }
    System.out.println("----------------------");
    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    l2.next.next.next = new ListNode(5);
    l2.next.next.next.next = new ListNode(6);
    ListNode tmp2 = l2;
    while (tmp2 != null) {
      System.out.print(tmp2.val + "->");
      tmp2 = tmp2.next;
    }

    System.out.println("----------------------");
    ListNode newhead = q.merge2(l1, l2);
    while (newhead != null) {
      System.out.print(newhead.val + "->");
      newhead = newhead.next;
    }

  }
}
