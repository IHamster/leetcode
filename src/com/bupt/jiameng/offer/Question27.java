package com.bupt.jiameng.offer;

import com.bupt.jiameng.contructs.TreeNode;

/**
 * User: jiameng
 * Date: 15/4/19
 * Time: 下午4:01
 */
//二叉搜索树与双向链表
//  输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的节点，只能调整树中节点指针的指向。
public class Question27 {
  public TreeNode lastNodeInList = null;
  public TreeNode covert(TreeNode root) {
    recursion(root);

    TreeNode tmp = lastNodeInList;
    while(tmp!=null && tmp.left!=null){
      tmp = tmp.left;
    }
    return tmp;
  }

  //in order traverse
  public void recursion(TreeNode node) {
    if (node == null) return;

    TreeNode cur = node;

    if (cur.left != null) {
      recursion(cur.left);
    }

    cur.left = lastNodeInList;
    if(lastNodeInList!=null){
      lastNodeInList.right = cur;
    }
    lastNodeInList = cur;


    if (cur.right != null) {
      recursion(cur.right);
    }

  }

  public static void main(String[] args) {
    Question27 q = new Question27();
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(6);
    root.right = new TreeNode(14);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(16);

    TreeNode tmp = q.covert(root);
    while(tmp!=null){
      System.out.println(tmp.val);
      tmp = tmp.right;
    }
  }
}
