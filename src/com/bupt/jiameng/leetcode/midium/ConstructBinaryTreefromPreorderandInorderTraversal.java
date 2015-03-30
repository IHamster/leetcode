package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.leetcode.contructs.TreeNode;

/**
 * Created by jiameng on 15/3/26.
 */
//给定前序遍历和中序遍历的结果，构建二叉树
//      1
//    2   3
//   4 5  6 7
//            8
//  pre: 1,2,4,5,3,6,7，8
//in:4，2，5，1，6，3，7，8
//  1


public class ConstructBinaryTreefromPreorderandInorderTraversal {
//  public TreeNode buildTree(int[] preorder, int[] inorder) {
//    if(preorder == null || inorder == null) return null;
//    if(preorder.length != inorder.length) return null;
//    if(preorder.length < 1 || inorder.length < 1) return null;
//
//    int rootVal = preorder[0];
//    TreeNode root = new TreeNode(rootVal);
//    //zuo
//    construct(root, preorder, inorder);
//    return root;
//  }
//
//  public void construct(TreeNode root, int[] preorder, int[] inorder){
//    if(preorder == null && inorder == null){
//      return;
//    }
//
//
//    int rootIndex = getIndex(inorder, root.val);//获取中序根节点的位置
//    int leftNodeNum = rootIndex;//左子树节点个数
//    int rightNodeNum = inorder.length - rootIndex - 1;//右子树节点个数
//    int[] leftpreOrder = getArray(preorder, 1, leftNodeNum);
//    int[] rightpreOrder = getArray(preorder, leftNodeNum + 1, preorder.length - 1);
//    int[] leftinOrder = getArray(inorder, 0, rootIndex - 1);
//    int[] rightinOrder = getArray(inorder, rootIndex + 1, inorder.length - 1);
//
//    root.left = null;
//    root.right = null;
//    if(leftNodeNum > 0){
//      root.left = new TreeNode(leftpreOrder[0]);
//    }
//    if(rightNodeNum > 0){
//      root.right = new TreeNode(rightpreOrder[0]);
//    }
//    construct(root.left, leftpreOrder, leftinOrder);
//    construct(root.right, rightpreOrder, rightinOrder);
//  }
//
//  public int[] getArray(int[] orign, int start, int end){
//    if(start > end ) return null;
//    int length = end - start + 1;
//    int[] tmp = new int[length];
//    for(int i = 0; i < length; i++){
//      tmp[i] = orign[start + i];
//    }
//    return tmp;
//  }
//
//  public int getIndex(int[] orign, int num){
//    int index = -1;
//    for(int i = 0; i < orign.length; i++){
//      if(orign[i] == num)
//        return i;
//    }
//    return index;
//  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1)
      return null;

    int rootValue = preorder[0];
    TreeNode root = new TreeNode(rootValue);
    root.left = root.right = null;

    if (preorder.length == 1 && inorder.length == 1) {
      return root;
    }

    int rootInOrder = getIndex(inorder, rootValue);
    int leftTreeLength = rootInOrder;
    if (leftTreeLength > 0)
      root.left = buildTree(getArray(preorder, 1, leftTreeLength), getArray(inorder, 0, leftTreeLength - 1));
    if (leftTreeLength < preorder.length - 1)
      root.right = buildTree(getArray(preorder, leftTreeLength + 1, preorder.length - 1), getArray(inorder, leftTreeLength + 1, inorder.length - 1));
    return root;
  }

  public int[] getArray(int[] orign, int start, int end) {
    if (start > end) return null;
    int length = end - start + 1;
    int[] tmp = new int[length];
    for (int i = 0; i < length; i++) {
      tmp[i] = orign[start + i];
    }
    return tmp;
  }

  public int getIndex(int[] orign, int num) {
    int index = -1;
    for (int i = 0; i < orign.length; i++) {
      if (orign[i] == num)
        return i;
    }
    return index;
  }

  public void construct(int[] preorder, int[] inorder) {
//    if(preorder == null && inorder == null){
//      return;
  }
}
