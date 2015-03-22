package com.bupt.jiameng.leetcode.easy;

/**
 * User: Administrator
 * Date: 2015/3/22
 * Time: 15:11
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
