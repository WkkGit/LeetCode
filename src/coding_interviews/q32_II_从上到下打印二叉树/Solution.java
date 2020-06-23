package coding_interviews.q32_II_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
    从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
/*
    这题和32-I思路一样， 使用Queue
    但是要在循环过程中多一个保存本层结果的步骤
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            // 用于存储本层结果
            List<Integer> temp = new ArrayList();
            // 当前queue的大小即为本层的结果
            /*
                这里不能使用int i = 0 ; i< queue.size(); i ++
                因为queue的长度每轮都是变化的
                可以写作
                size = queue.size() - 1;
                for(int i = 0 ; i < size; i ++)
             */
            for(int i = queue.size(); i > 0; i --){
                TreeNode node = queue.poll();
                temp.add(node.val);
                // 添加下一层的节点
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
