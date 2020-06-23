package coding_interviews.q07_重建二叉树;

import java.util.ArrayList;
import java.util.List;

/**
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
/*
    递归完成
    1.前序遍历的第一个元素一定是根节点
    2.获取根节点在中序遍历中的index，将中序遍历分割为两部分，左侧即为左子树，右侧即为右子树
    3.左右子树重复1,2步骤
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList();
        List<Integer> ino = new ArrayList();
        // 将数组转化为list
        for(int i: preorder){
            pre.add(i);
        }
        for(int i: inorder){
            ino.add(i);
        }

        return build(pre,ino);
    }

    public TreeNode build(List preorder, List inorder){
        // 递归出口，元素全部使用
        if(preorder.size() == 0)return null;
        // 前序遍历的第一个元素一定是根节点
        int root_val = (int)preorder.get(0);
        TreeNode root = new TreeNode(root_val);
        // 获取根节点在中序遍历中的位置，左边即为左子树，右边即为右子树
        int root_index = inorder.indexOf(root_val);
        // 构建左子树，左闭右开，所以index+1
        root.left = build(preorder.subList(1,root_index+1), inorder.subList(0,root_index+1));
        // 构建右子树，左闭右开
        root.right = build(preorder.subList(root_index+1,preorder.size()),inorder.subList(root_index+1, inorder.size()));

        return root;
    }
}
