package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.TreeNode;

/**
 * User: jiameng
 * Date: 15/5/9
 * Time: 下午11:44
 */
public class SumRoottoLeafNumbers {
  private int totalSum = 0;
  public int sumNumbers(TreeNode root) {
    if(root==null) return 0;
    recursion(root,0);
    return totalSum;
  }

  private void recursion(TreeNode root,int sum){
    if(root == null){
      return;
    }else{
      sum = sum*10+root.val;
      if(root.left !=null){
        recursion(root.left,sum);
      }
      if(root.right!=null){
        recursion(root.right,sum);
      }
      if(root.left==null && root.right==null)
        totalSum+=sum;
    }
  }

  public static void main(String[] args){
    SumRoottoLeafNumbers sr = new SumRoottoLeafNumbers();
    TreeNode root = new TreeNode(9);
    System.out.println(sr.sumNumbers(root));
  }
}
