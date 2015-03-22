package com.bupt.jiameng.leetcode.easy;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2015/3/21.
 */
public class BinaryTreeLevelOrderTraversal {
    //bfs
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        List<List<Integer>> list = new LinkedList<List<Integer>>();
//
//        if (root == null) return list;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int levelNum = queue.size();//每层的个数
//            List<Integer> subList = new LinkedList<Integer>();
//            for(int i = 0; i < levelNum; i++){
//                if(queue.peek().left != null) queue.offer(queue.peek().left);
//                if(queue.peek().right != null) queue.offer(queue.peek().right);
//                subList.add(queue.poll().val);
//            }
//            list.add(0,subList);
//        }
//        return list;
//    }

    //dfs
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        levelMaker(list, root, 0);
        return list;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if(level == list.size())
            list.add(0, new LinkedList<Integer>());
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size()-level-1).add(root.val);

    }

}
