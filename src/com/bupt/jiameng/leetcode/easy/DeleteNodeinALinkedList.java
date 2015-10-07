package com.bupt.jiameng.leetcode.easy;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/10/7
 * Time: 下午2:03
 */
//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//    Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
// the linked list should become 1 -> 2 -> 4 after calling your function.
public class DeleteNodeinALinkedList {
  public void deleteNode(ListNode node) {
    if(node == null){
      return;
    }
    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
  }
}
