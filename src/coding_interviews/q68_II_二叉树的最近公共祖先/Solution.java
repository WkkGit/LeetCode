package coding_interviews.q68_II_二叉树的最近公共祖先;

/**
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
/*
    https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件，root == null或者root等于pq中的一个
        if(root == null || root == p || root == q){
            return root;
        }
        // 遍历左右子树
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 子树中没有p或q
        if(left==null){
            return right;
        }
        // 右子树没有p或q
        if(right == null){
            return left;
        }
        // 如果left和right都不为空，说明pq分别在root的两侧，root即为公共祖先
        return  root;
    }
}
