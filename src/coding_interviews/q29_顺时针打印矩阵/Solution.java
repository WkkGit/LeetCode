package coding_interviews.q29_顺时针打印矩阵;

/**
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
/*
    顺时针打印矩阵的顺序是 “从左向右、从上向下、从右向左、从下向上” 的循环。
    每打印一次，边界收缩一次
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        // 定义初始边界
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        // 定义res的初始下标
        int index = 0;
        while(true) {
            // 首行从左到右
            for(int i = left; i <= right; i++) res[index ++] = matrix[top][i];
            // 收缩边界
            if(++top > bottom) break;
            // 尾列从上到下
            for(int i = top; i <= bottom; i++) res[index ++] = matrix[i][right];
            // 收缩边界
            if(left > --right) break;
            // 尾行从右到左
            for(int i = right; i >= left; i--) res[index ++] = matrix[bottom][i];
            // 收缩边界
            if(top > --bottom) break;
            // 首列从下到上
            for(int i = bottom; i >= top; i--) res[index ++] = matrix[i][left];
            // 收缩边界
            if(++left > right) break;
        }
        return res;
    }
}
