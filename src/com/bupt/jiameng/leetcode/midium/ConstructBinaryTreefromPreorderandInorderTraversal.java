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
  1


public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || inorder == null) return null;
    if(preorder.length != inorder.length) return null;
    if(preorder.length < 1 || inorder.length < 1) return null;

    int rootVal = preorder[0];
    TreeNode root = new TreeNode(rootVal);
    //zuo
    construct(root, preorder, inorder);
    return root;
  }

  public void construct(TreeNode root, int[] preoeder, int[] inorder){
    if(preoeder.length == 0){
      root.left = null;
      root.right = null;
      return;
    }else{

    }

    int rootIndex = getIndex(inorder, root.val);//获取中序根节点的位置
    int leftNodeNum = rootIndex;//左子树节点个数
    int rightNodeNum = inorder.length - rootIndex - 1;//右子树节点个数
    int[] leftpreOrder = getArray(preoeder, 1, leftNodeNum);
    int[] rightpreOrder = getArray(preoeder, leftNodeNum + 1, preoeder.length - 1);
    int[] leftinOrder = getArray(inorder, 1, rootIndex - 1);
    int[] rightinOrder = getArray(inorder, rootIndex + 1, inorder.length - 1);
    //获取左子树根节点，前序和中序
    construct(new TreeNode(leftpreOrder[0]), leftpreOrder, leftinOrder);
    construct(new TreeNode(rightpreOrder[0]), rightpreOrder, rightinOrder);


  }

  public int[] getArray(int[] orign, int start, int end){
    int length = end - start + 1;
    int[] tmp = new int[length];
    for(int i = 0; i < length; i++){
      tmp[i] = orign[start + i];
    }
    return tmp;
  }

  public int getIndex(int[] orign, int num){
    int index = -1;
    for(int i = 0; i < orign.length; i++){
      if(orign[i] == num)
        return i;
    }
    return index;
  }
}
