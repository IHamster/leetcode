package com.bupt.jiameng.offer;

import com.bupt.jiameng.contructs.ComplexListNode;
import sun.plugin.converter.util.CommandLineException;

/**
 * User: jiameng
 * Date: 15/4/17
 * Time: 下午11:43
 */
//复杂链表的复制
//  分成三步
public class Question26 {

  public ComplexListNode clone(ComplexListNode head) {
    cloneNodes(head);
    connectSiblingNodes(head);
    return reconnectNodes(head);
  }

  //复制原始链表的任意节点N并创建新节点N‘，再把N’链接到N的后面
  public void cloneNodes(ComplexListNode head) {
    ComplexListNode p = head;
    while (p != null) {
      ComplexListNode clone = new ComplexListNode(p.val);
      clone.next = p.next;
      p.next = clone;
      p = clone.next;
    }
  }

  //  复制原始链表的第二步
//  如果原始链表上的节点N的兄弟节点指向S，则它对应的复制节点N‘的兄弟节点指向S的下一节点。
  public void connectSiblingNodes(ComplexListNode head) {
    ComplexListNode p = head;
    while (p != null) {
      if (p.sibling != null) {
        p.next.sibling = p.sibling.next;
      }
      p = p.next.next;
    }
  }

  //  复制原始链表的第三步
//  分离链表，奇数点为原链表，偶数点为复制的链表
  public ComplexListNode reconnectNodes(ComplexListNode head) {
    ComplexListNode p = head;
    ComplexListNode cloneHead = null;
    ComplexListNode cloneTmpHead = null;
    if (p != null) {
      cloneHead = p.next;
      cloneTmpHead = cloneHead;
      p.next = cloneTmpHead.next;
      p = p.next;
    }
    while (p != null) {
      cloneTmpHead.next = p.next;
      cloneTmpHead = cloneTmpHead.next;
      p.next = cloneTmpHead.next;
      p = p.next;
    }

    return cloneHead;
  }

  public static void main(String[] args) {

  }
}
