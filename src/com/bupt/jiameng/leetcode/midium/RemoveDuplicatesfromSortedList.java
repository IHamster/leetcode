package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.ListNode;

/**
 * Created by jiameng on 15/3/25.
 */
public class RemoveDuplicatesfromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode tmp = newHead;
    boolean flag = false;
    while(tmp.next != null && tmp.next.next != null){
      if(tmp.next.val == tmp.next.next.val){
        flag = true;
        tmp.next = tmp.next.next;
      }else {
        if(flag){
          tmp.next = tmp.next.next.next;
          flag = false;
        }else{
          tmp = tmp.next;
        }
      }
    }
    return newHead.next;
  }
}
