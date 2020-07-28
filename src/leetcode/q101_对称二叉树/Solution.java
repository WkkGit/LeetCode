package leetcode.q101_对称二叉树;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 非对称：
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 对称：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return match(root.left, root.right);
    }

    private boolean match(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return match(node1.left, node2.right) && match(node1.right, node2.left);
    }
}
