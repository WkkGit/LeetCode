package coding_interviews.q68_I_二叉搜索树的最近公共祖先;
/**
 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
/*
    https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            // 如果root大于p、q，则说明pq在左子树，遍历左子树
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                // 如果root小于p、q，则说明pq在右子树，遍历右子树
                root = root.right;
            }else{
                // 如果qp在root两边，那么当前root就是其公共祖先
                break;
            }
        }
        return root;
    }
}
