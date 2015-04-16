package com.bupt.jiameng.offer;

import com.bupt.jiameng.leetcode.contructs.ListNode;
import com.bupt.jiameng.leetcode.contructs.TreeNode;

/**
 * User: jiameng
 * Date: 15/4/15
 * Time: 下午10:17
 */
//树的子结构:输入两个二叉树，判断B是不是A的子树
public class Question18 {
  public boolean hasSubTree(TreeNode root1, TreeNode root2) {
    boolean isSame = false;
    if (root1 == null || root2 == null) return isSame;

    if (root1.val == root2.val) {
      isSame = recursion(root1, root2);
    }
    if (!isSame) {
      isSame = hasSubTree(root1.left, root2);
    }
    if (!isSame) {
      isSame = hasSubTree(root1.right, root2);
    }

    return isSame;
  }

  private boolean recursion(TreeNode root1, TreeNode root2) {
    if (root2 == null)
      return true;
    if (root1 == null)
      return false;
    if (root1.val != root2.val)
      return false;

    return recursion(root1.left, root2.left) && recursion(root1.right, root2.right);
  }

  public static void main(String[] args){
    Question18 q = new Question18();
    TreeNode root1 = new TreeNode(8);
    root1.left = new TreeNode(8);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(9);
    root1.left.right = new TreeNode(2);
    root1.left.right.left = new TreeNode(4);
    root1.left.right.right = new TreeNode(7);

    TreeNode root2 = new TreeNode(8);
    root2.left = new TreeNode(9);
    root2.right = new TreeNode(2);

    boolean isSame = q.hasSubTree(root1,root2);
    System.out.println(isSame);
  }
}
