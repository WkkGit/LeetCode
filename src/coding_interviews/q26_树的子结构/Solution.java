package coding_interviews.q26_树的子结构;

/**
    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
/*
    先序遍历树 A 中的每个节点 n_A（对应函数 isSubStructure(A, B)）
    判断树 A 中 以 n_A为根节点的子树 是否包含树 B（对应函数 recur(A, B)）

    https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        // 先判断A和B是否从根节点开始匹配，否则判断左右子节点
        // 调用isSubStructure就是为了在A中找到B根节点的其实位置
        boolean flag = judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        return flag;
    }
    // 进行比较的方法
    public boolean judge(TreeNode A, TreeNode B){
        // B树先遍历结束，说明A中包含B
        if(B == null){
            return true;
        }
        // A树先遍历结束，或者值不相同，说明A中不包含B
        if(A == null || A.val != B.val){
            return false;
        }
        // 值相同，递归子节点
        boolean flag = judge(A.left, B.left) && judge(A.right, B.right);
        return flag;
    }
}
