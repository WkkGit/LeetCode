package coding_interviews.q55_II_平衡二叉树;

/**
    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
/*
    分别获取当前节点的左右子树的最大深度，判断相减绝对值是否小于2，是则为平衡二叉树，否则不是平衡二叉树

    注意！每个节点都要判断一次左右子树的深度差
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return deep(root) != -1;
    }
    public int deep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = deep(root.left);
        // 左子树不符合条件，直接返回，不必再遍历右子树
        if(left == -1){
            return -1;
        }
        int right = deep(root.right);
        if(right == -1){
            return -1;
        }
        // 任意节点都要进行一次判断，子树差值是否小于1
        if(Math.abs(left - right) >= 2){
            return -1;
        }
        return Math.max(deep(root.left),deep(root.right))+1;
    }
}