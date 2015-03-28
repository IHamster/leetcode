package com.bupt.jiameng.leetcode.easy;

/**
 * User: Administrator
 * Date: 2015/3/22
 * Time: 22:50
 */
public class SameTree {
  private boolean isSame = true;
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) {
      isSame = false;
      return isSame;
    }
    if(p.val != q.val){
      isSame = false;
      return isSame;
    }
    isSameTree(p.left, q.left);
    isSameTree(p.right, q.right);
    return isSame;
  }
}
