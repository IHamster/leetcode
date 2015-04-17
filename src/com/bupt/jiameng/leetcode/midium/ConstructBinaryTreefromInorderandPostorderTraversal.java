package com.bupt.jiameng.leetcode.midium;

import com.bupt.jiameng.contructs.TreeNode;

/**
 * Created by jiameng on 15/3/28.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder == null || inorder == null) return null;
    if(postorder.length != inorder.length) return null;
    if(postorder.length < 1 || inorder.length < 1) return null;

    int rootVal = postorder[postorder.length-1];
    TreeNode root = new TreeNode(rootVal);
    //zuo
    construct(root, postorder, inorder);
    return root;
  }

  public void construct(TreeNode root, int[] postorder, int[] inorder){
    if(postorder == null && inorder == null){
      return;
    }

    int rootIndex = getIndex(inorder, root.val);//获取中序根节点的位置
    int leftNodeNum = rootIndex;//左子树节点个数
    int rightNodeNum = inorder.length - rootIndex - 1;//右子树节点个数
    int[] leftpostOrder = getArray(postorder, 0, rootIndex - 1);
    int[] leftinOrder = getArray(inorder, 0, rootIndex - 1);

    int[] rightpostOrder = getArray(postorder, leftNodeNum , postorder.length - 2);
    int[] rightinOrder = getArray(inorder, rootIndex + 1, inorder.length-1);

    root.left = null;
    root.right = null;
    if(leftNodeNum > 0){
      root.left = new TreeNode(leftpostOrder[leftpostOrder.length-1]);
    }
    if(rightNodeNum > 0){
      root.right = new TreeNode(rightpostOrder[rightpostOrder.length-1]);
    }
    construct(root.left, leftpostOrder, leftinOrder);
    construct(root.right, rightpostOrder, rightinOrder);
  }

  public int[] getArray(int[] orign, int start, int end){
    if(start > end || start > orign.length - 1) return null;
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
      if(orign[i] == num){
        return i;
      }
    }
    return index;
  }

  public static void main(String[] args){
    ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
    int[] in = {1,2};
    int[] post = {2,1};

    c.buildTree(in,post);



  }
}
