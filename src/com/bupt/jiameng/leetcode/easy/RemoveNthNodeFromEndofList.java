package com.bupt.jiameng.leetcode.easy;

import com.bupt.jiameng.contructs.ListNode;

/**
 * Created by jiameng on 15/4/4.
 */
//Given a linked list, remove the nth node from the end of list and return its head.
//Given linked list: 1->2->3->4->5, and n = 2.
//
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
public class RemoveNthNodeFromEndofList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || n == 0) return head;
    int length = 0;
    ListNode newHead = new ListNode(0);
    newHead.next = head;

    ListNode tmp = head;
    while (tmp != null){
      length ++;
      tmp = tmp.next;
    }
    tmp = newHead;

    int step = length -n;
    while(step >0){
      tmp = tmp.next;
      step--;
    }
    tmp.next = tmp.next.next;

    return newHead.next;

  }
}
