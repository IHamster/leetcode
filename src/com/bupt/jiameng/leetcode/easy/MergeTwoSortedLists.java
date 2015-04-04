package com.bupt.jiameng.leetcode.easy;

import com.bupt.jiameng.leetcode.contructs.ListNode;

/**
 * Created by jiameng on 15/4/4.
 */
public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode newHead = new ListNode(0);//new head
    ListNode newTmp = newHead;
    ListNode tmp1 = l1;
    ListNode tmp2 = l2;
    while (tmp1 != null && tmp2 != null) {
       if(tmp1.val<=tmp2.val){
         newTmp.next = tmp1;
         tmp1 = tmp1.next;
       }else{
         newTmp.next = tmp2;
         tmp2 = tmp2.next;
       }
      newTmp = newTmp.next;
    }

    while(tmp1 != null){
      newTmp.next = tmp1;
      newTmp = newTmp.next;
      tmp1 = tmp1.next;
    }

    while(tmp2 != null){
      newTmp.next = tmp2;
      newTmp = newTmp.next;
      tmp2 = tmp2.next;
    }
    return newHead.next;
  }
}
