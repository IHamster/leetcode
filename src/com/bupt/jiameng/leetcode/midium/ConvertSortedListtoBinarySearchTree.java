package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.ListNode;
import com.bupt.jiameng.contructs.TreeNode;

/**
 * User: jiameng
 * Date: 15/5/23
 * Time: 下午4:35
 */
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class ConvertSortedListtoBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    if(head == null) return null;
    return getMidNode(head);
  }

  public TreeNode getMidNode(ListNode start){
    if(start == null) return null;

    ListNode slow = start;
    ListNode fast = start;
    ListNode preMid = null;
    ListNode mid = null;
    TreeNode node = null;
    while(fast != null && fast.next!=null){
      fast = fast.next;
      fast = fast.next;
      preMid = slow;
      slow = slow.next;
      mid = slow;
    }

    if(preMid != null){
      node = new TreeNode(mid.val);
      preMid.next = null;
    }else{
      return new TreeNode(start.val);
    }

    node.left = getMidNode(start);
    node.right = getMidNode(mid.next);

    return node;
  }

  public static void main(String[] args){
    ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
    ListNode head = new ListNode(0);
    TreeNode root = c.getMidNode(head);
    System.out.println(root.val);
  }
}
