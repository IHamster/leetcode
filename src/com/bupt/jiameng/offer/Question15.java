package com.bupt.jiameng.offer;

import com.bupt.jiameng.contructs.ListNode;

/**
 * User: jiameng
 * Date: 15/4/15
 * Time: 下午7:45
 */
//链表中倒数第k个节点
public class Question15 {
  public ListNode fingKthToTail(ListNode head, int k) {
    if (head == null || k == 0) return null;
    ListNode l1 = head;// go first k-1 step
    ListNode l2 = head;
    int step = k - 1;
    while (step > 0) {
      if (l1.next != null) {
        l1 = l1.next;
        step--;
      } else return null;
    }
    while (l1.next != null) {

      l1 = l1.next;
      l2 = l2.next;
    }

    return l2;
  }

  public static void main(String[] args) {
    Question15 q = new Question15();
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
    System.out.println();
    ListNode target = q.fingKthToTail(head, 1);
    if (target == null) System.out.println("is null");
    else
      System.out.println(target.val);
  }
}
