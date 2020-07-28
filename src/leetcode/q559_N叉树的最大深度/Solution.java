package leetcode.q559_N叉树的最大深度;

public class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null){
            return 1;
        }
        int max = 0;
        for(Node node : root.children){
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
