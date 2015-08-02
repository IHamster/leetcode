package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/7/31
 * Time: 下午6:52
 */
//Given a linked list and a value x, partition it such that all nodes
// less than x come before nodes greater than or equal to x.
//
//    You should preserve the original relative order of the nodes in each of the two partitions.
//
//    For example,
//    Given 1->4->3->2->5->2 and x = 3,
//    return 1->2->2->4->3->5.
public class PartitionList {

  //solution 1: create two list, one hold the small nodes, another hold the big nodes.
  public ListNode partition(ListNode head, int x) {
    if (head == null) return head;
    ListNode small = new ListNode(-1);
    ListNode big = new ListNode(-1);
    ListNode tmp = head;
    ListNode tmpSmall = small;
    ListNode tmpBig = big;

    while (tmp != null) {
      if (x > tmp.val) {
        tmpSmall.next = new ListNode(tmp.val);
        tmpSmall = tmpSmall.next;
      } else {
        tmpBig.next = new ListNode(tmp.val);
        tmpBig = tmpBig.next;
      }
      tmp = tmp.next;
    }
    tmpSmall.next = big.next;
    return small.next;
  }

  //solution 2: use two pointers
  public ListNode partition2(ListNode head, int x) {
    if (head == null) return head;
    ListNode small = new ListNode(-1);
    ListNode big = new ListNode(-1);
    ListNode tmp = head;
    ListNode tmpSmall = small;
    ListNode tmpBig = big;
    while (tmp != null) {
      if (x > tmp.val) {
        tmpSmall.next = tmp;
        tmpSmall = tmpSmall.next;
      } else {
        tmpBig.next = tmp;
        tmpBig = tmpBig.next;
      }
      tmp = tmp.next;
    }
    tmpBig.next = null;
    tmpSmall.next = big.next;
    return small.next;
  }



  public static void main(String[] args) {
    PartitionList p = new PartitionList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);
    ListNode test = p.partition2(head, 3);
    while (test != null) {
      System.out.print(test.val + "->");
      test = test.next;
    }
  }
}
