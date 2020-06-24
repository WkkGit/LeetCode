package coding_interviews.q32_III_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] temp = new int[size];
            List<Integer> list = new ArrayList();
            for(int i = 0 ; i < size; i ++){
                TreeNode node = queue.poll();
                temp[i] = node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(flag){
                for(int i = 0; i < size; i ++){
                    list.add(temp[i]);
                }
                flag = false;
            }else{
                for(int i = size; i > 0 ; i --){
                    list.add(temp[i-1]);
                }
                flag = true;
            }
            res.add(list);
        }
        return res;
    }
}
