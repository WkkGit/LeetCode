package leetcode.q111_二叉树的最小深度;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
/*
    注意！最小深度是从根节点开始的计算的！！
    所以如果一个节点左节点为null，右节点存在值（或者右null，左有值），那么为null的子树是不参与比较的
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null && root.left != null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
