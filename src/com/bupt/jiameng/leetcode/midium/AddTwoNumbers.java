package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/4/14
 * Time: 下午6:09
 */

//You are given two linked lists representing two non-negative numbers.
//    The digits are stored in reverse order and each of their nodes contain a single digit.
//    Add the two numbers and return it as a linked list.
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//  tag:linked list math
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode head = new ListNode(0);
    ListNode tmpHead = head;
    ListNode tmp1 = l1;
    ListNode tmp2 = l2;
    int cache = 0;
    while (tmp1 != null && tmp2 != null) {
      int val = (cache + tmp1.val + tmp2.val) % 10;
      cache = (tmp1.val + tmp2.val + cache) / 10;
      tmpHead.next = new ListNode(val);
      tmpHead = tmpHead.next;
      tmp1 = tmp1.next;
      tmp2 = tmp2.next;
    }

    if (tmp1 == null) {
      while (tmp2 != null) {
        int val = (cache + tmp2.val) % 10;
        cache = (tmp2.val + cache) / 10;
        tmpHead.next = new ListNode(val);
        tmpHead = tmpHead.next;
        tmp2 = tmp2.next;
      }
    } else {
      while (tmp1 != null) {
        int val = (cache + tmp1.val) % 10;
        cache = (tmp1.val + cache) / 10;
        tmpHead.next = new ListNode(val);
        tmpHead = tmpHead.next;
        tmp1 = tmp1.next;
      }
    }

    if (cache != 0)
      tmpHead.next = new ListNode(cache);

    return head.next;
  }

//  public static void main()
}
