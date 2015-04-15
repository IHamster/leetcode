package com.bupt.jiameng.offer;

import com.bupt.jiameng.leetcode.contructs.ListNode;

import java.util.List;

/**
 * User: jiameng
 * Date: 15/4/15
 * Time: 下午8:31
 */
//反转链表
public class Question16 {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;// list is null
    if(head.next == null) return head;//list has only one node

    // list has two node at least
    ListNode newHead = null;
    ListNode preNode = head;
    ListNode curNode = head.next;
    ListNode nextNode = head.next.next;
    preNode.next = null;//next of tail node is null
    while(nextNode!=null){
      curNode.next = preNode;
      preNode = curNode;
      curNode = nextNode;
      nextNode = nextNode.next;
    }
    curNode.next = preNode;
    newHead = curNode;

    return newHead;
  }

  public static void main(String[] args){
    Question16 q = new Question16();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode tmp = head;
    while (tmp != null) {
      System.out.print(tmp.val + "->");
      tmp = tmp.next;
    }
    System.out.println("---------------");
    ListNode newhead = q.reverseList(head);
    tmp = newhead;
    while (tmp != null) {
      System.out.print(tmp.val + "->");
      tmp = tmp.next;
    }
  }
}
