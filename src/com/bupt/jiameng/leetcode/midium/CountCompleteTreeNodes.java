package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.TreeNode;

/**
 * User: jiameng
 * Date: 15/8/5
 * Time: 下午11:36
 */
//Given a complete binary tree, count the number of nodes.
//
//    Definition of a complete binary tree from Wikipedia:
//    In a complete binary tree every level, except possibly the last,
//    is completely filled, and all nodes in the last level are as far left as possible.
//    It can have between 1 and 2^h nodes inclusive at the last level h.
public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    int levelCount = 1;
    int totalCount = 1;
    TreeNode leftNode = root.left;
    TreeNode rightNode = root.right;
    while (leftNode != null && rightNode != null) {
      levelCount = levelCount << 1;
      totalCount = levelCount + totalCount;
      leftNode = leftNode.left;
      rightNode = rightNode.right;
    }
    if (leftNode == null && rightNode == null) {
      return totalCount;
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  public static void main(String[] args) {
    CountCompleteTreeNodes c = new CountCompleteTreeNodes();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
//    root.right.left = new TreeNode(6);
//    root.right.right = new TreeNode(7);
    System.out.println(c.countNodes(root));
  }
}
