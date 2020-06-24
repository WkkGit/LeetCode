package coding_interviews.q28_对称的二叉树;
/**
    请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
       / \
      2   2
       \   \
       3    3
 */

/*
    镜像对称需要满足：
            L.val=R.val
            L.left.val = R.right.val
            L.right.val = R.left.val
    所以递归判断即可
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return judge(root.left,root.right);
    }

    public boolean judge(TreeNode left, TreeNode right){
        // 递归出口，越出叶子节点
        if(left ==  null && right == null){
            return true;
        }
        // 值不相等，返回false
        if(left == null || right == null || left.val != right.val){
            return false;
        }

        // 值相等，递归判断子节点
        boolean flag = judge(left.left,right.right) && judge(left.right,right.left);
        return flag;
    }
}
