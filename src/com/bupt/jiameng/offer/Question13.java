package com.bupt.jiameng.offer;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/4/12
 * Time: 下午10:52
 */
//在o(1)时间删除链表节点
public class Question13 {
  public ListNode deleteNode(ListNode head, ListNode toDelete) {
    if(head == null || toDelete==null) return null;

    ListNode tmpHead = head;
//    要删除的不是尾节点
    if(toDelete.next != null){
      ListNode tmpNext = toDelete.next.next;
      toDelete.val = toDelete.next.val;
      toDelete.next = tmpNext;
      tmpNext = null;
    }else if(head == toDelete){//only have head node
      tmpHead = null;
    }else{// delete the tail node, only can traverse
      while(tmpHead.next != toDelete){
        tmpHead = tmpHead.next;
      }
      tmpHead.next = null;
    }
    return tmpHead;
  }

  public static void main(String[] args){
    Question13 q = new Question13();
    ListNode head = new ListNode(0);
//    head.next = new ListNode(1);
//    head.next.next = new ListNode(2);
    ListNode tmp = head;
    while(tmp!=null){
      System.out.println(tmp.val);
      tmp = tmp.next;
    }
    ListNode newHead= q.deleteNode(head, head);
    tmp = newHead;
    while(tmp!=null){
      System.out.println(tmp.val);
      tmp = tmp.next;
    }
  }
}
