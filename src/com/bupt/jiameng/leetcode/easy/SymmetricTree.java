package com.bupt.jiameng.leetcode.easy;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * User: Administrator
 * Date: 2015/3/22
 * Time: 19:48
 */
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
public class SymmetricTree {
    private static boolean isSym = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        turn(root.right);//将右子树水平180度翻转
        isSame(root.left, root.right);

        return SymmetricTree.isSym;
    }

    //将树水平180度翻转
    public void turn(TreeNode root){
        if(root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        turn(root.left);
        turn(root.right);
    }

    //判断两课树是否相等
    public void isSame(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return;
        if(t1 == null || t2 == null){
            SymmetricTree.isSym = false;
            return;
        }
        if(t1.val != t2.val) {
            SymmetricTree.isSym = false;
            return;
        }
        isSame(t1.left, t2.left);
        isSame(t1.right, t2.right);
    }

    public static void main(String[] args){
        SymmetricTree s = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(root));
    }
}
