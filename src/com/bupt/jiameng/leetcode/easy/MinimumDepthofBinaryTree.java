package com.bupt.jiameng.leetcode.easy;

/**
 * Created by Administrator on 2015/3/17.
 */

// Definition for binary tree


public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 && right == 0 ) return 1;
        if(left == 0) left = Integer.MAX_VALUE;
        if(right == 0) right = Integer.MAX_VALUE;

        return Math.min(left, right) + 1;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
