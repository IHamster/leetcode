package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/5/23
 * Time: 下午8:22
 */
//Sort a linked list in O(n log n) time using constant space complexity.
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    return mergeSort(head);
  }

  public ListNode mergeSort(ListNode head) {
    if (head.next == null) return head;//only one node,return
    //int len = getLength(head);
    //int mid = len/2;
    //if(mid == 0) return;
    ListNode slow = head;
    ListNode fast = head;
    ListNode preMid = null;
    while (fast != null && fast.next != null) {
      fast = fast.next;
      fast = fast.next;
      preMid = slow;
      slow = slow.next;
    }
    preMid.next = null;//break the list from mid
    ListNode index1 = mergeSort(head);
    ListNode index2 = mergeSort(slow);
    return merge(index1,index2);
  }

  public ListNode merge(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) return null;
    ListNode index1 = head1;
    ListNode index2 = head2;
    ListNode node = null;
    ListNode newHead = null;
    if (index1.val < index2.val) {
      node = index1;
      index1 = index1.next;
      node.next = null;
    } else {
      node = index2;
      index2 = index2.next;
      node.next = null;
    }
    newHead = node;
    while (index1 != null && index2 != null) {
      if (index1.val <= index2.val) {
        node.next = index1;
        ListNode next1 = index1.next;
        node = node.next;
        node.next = null;
        index1 = next1;
      } else {
        node.next = index2;
        ListNode next2 = index2.next;
        node = node.next;
        node.next = null;
        index2 = next2;
      }
    }

    if (index1 == null)
      node.next = index2;
    if (index2 == null)
      node.next = index1;
    return newHead;
  }

  public static void main(String[] args){
    SortList sl = new SortList();
    ListNode head = new ListNode(3);
    head.next = new ListNode(1);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    ListNode node = sl.sortList(head);
    while (node!=null){
      System.out.print(node.val+"->");
      node = node.next;
    }
//    head.next = new ListNode(1);
  }
}
