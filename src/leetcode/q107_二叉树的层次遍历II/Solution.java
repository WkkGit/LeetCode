package leetcode.q107_二叉树的层次遍历II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
/*
    使用LinkedList，每次遍历一层的节点后都添加到头部（addFirst）
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        LinkedList<List<Integer>> res = new LinkedList();
        if(root == null){
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.addFirst(temp);
        }
        return res;
    }
}
