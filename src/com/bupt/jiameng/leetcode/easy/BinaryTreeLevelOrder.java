package com.bupt.jiameng.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: Administrator
 * Date: 2015/3/22
 * Time: 15:34
 */
public class BinaryTreeLevelOrder {
    //BFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new LinkedList<List<Integer>>();
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//
//        if(root == null) return list;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int levelNum = queue.size();
//            List<Integer> tmp = new LinkedList<Integer>();
//            for(int i = 0; i < levelNum; i++){
//                if(queue.peek().left != null) queue.offer(queue.peek().left);
//                if(queue.peek().right != null) queue.offer(queue.peek().right);
//                tmp.add(queue.poll().val);
//            }
//            list.add(tmp);
//        }
//        return list;
//
//    }

    //DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        maker(root, list, 0);
        return list;

    }

    private void maker(TreeNode root, List<List<Integer>> list, int level){
        if(root == null) return;
        if(level == list.size())
            list.add(new LinkedList<Integer>());
        maker(root.left, list, level + 1);
        maker(root.right, list, level + 1);
        list.get(level).add(root.val);
    }

}
