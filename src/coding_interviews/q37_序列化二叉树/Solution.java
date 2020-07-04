package coding_interviews.q37_序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
    请实现两个函数，分别用来序列化和反序列化二叉树。
    你可以将以下二叉树：
      1
     / \
    2   3
   / \
  4   5
 序列化为 "[1,2,3,null,null,4,5]"
 */
/*
    序列化流程
        特例处理： 若 root 为空，则直接返回空列表 "[]" ；
        BFS遍历二叉树，但是在遍历的时候对node进行判断
            若 node 不为空：添加字符串 node.val+"," ，将左、右子节点加入 queue ；
            若 node 为空：添加字符串 "null," ；
        返回值： 拼接列表（用 ',' 隔开，首尾添加中括号）

    反序列化流程
        特例处理： 若 data 为"[]"，直接返回 null ；
        初始化： 获取root的val列表 vals （先去掉首尾中括号，再用逗号隔开）
                设置指针 i=1（当前指向的vals）
                创建根节点 root （值为 vals[0]）
                创建队列 queue 并添加 root；
        按层构建： 当 queue 为空时跳出；
                  节点出队，记为 node ；
                  构建 node 的左子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
                  执行 i++ ；
                  构建 node 的右子节点：node.right 的值为 vals[i] ，并将 node.right 入队；
                  执行 i++ ；
        返回值： 返回根节点 root 即可。
 */
public class Solution {
    // 序列化二叉树
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // BFS遍历节点，同时拼接到res后面
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        // 删除最后一个元素后面的逗号
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }
    // 二叉树的反序列化
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        // 将节点的val分割开来，参数区间为左开右闭，不包括"[]"
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // 第一个是root节点，后面从下标1开始构建二叉树
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // BFS后的数组顺序为：根、左、右，所以先构建左节点
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
