package coding_interviews.q32_I_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
    从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
/*
    从上到下打印，即BFS（广度优先）
    广度优先一般选择使用Queue的先进先出特性来完成
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<Integer> res = new ArrayList();
        // 利用队列的先进先出原则
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // 先存根节点，在存左节点，最后存右节点
        // 左节点的子节点晚于右节点，所以一层打印结束后才会进入下一层
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++){
            result[i] = res.get(i);
        }
        return result;
    }
}
