package coding_interviews.q34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList();
    List<Integer> list = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        dfs(root, sum);

        return result;
    }

    private void dfs(TreeNode root, int target){
        target -= root.val;
        // 如果到达叶子节点时结果符合，将当前路径添加到result中
        if(target == 0 && root.left == null & root.right == null){
            list.add(root.val);
            // 这里使用new ArrayList是将list复制一份放入resutl中，如果直接add(list)，那么list就会被改变，影响后续遍历
            result.add(new ArrayList(list));
            // 移除最后一个节点，保留之前的路径，方便遍历其兄弟节点，即退回上层
            list.remove(list.size() - 1);
            return;
        }
        // 如果没有到达叶子节点，保存路劲，进行左右子树遍历
        list.add(root.val);
        if(root.left != null){
            dfs(root.left, target);
        }
        if(root.right != null){
            dfs(root.right, target);
        }
        // 如果递归到叶子节点后还不符合，移除这个节点，进行其他兄弟节点的遍历，即退回上层
        list.remove(list.size() - 1);
    }
}
