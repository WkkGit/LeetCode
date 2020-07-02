package coding_interviews.q47_礼物的最大价值;

/**
    在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */

/*
    1.推出公式
        每一个格子的最大值等于其左边和上边中最大值加上格子本身价值
        value(i,j) = Max(value(i-1,j), value(i,j-1)) + arr(i,j);
        value(0,0) = arr(0,0);

    2.对首行和首列进行前缀和处理
    3.对整个格子进行最大值搜索
    4.返回最大值
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 保存对格子的礼物最大值
        int[][] dp = new int[row][col];
        // 只选一个礼物的最大价值
        dp[0][0] = grid[0][0];
        // 这两个for循环称作前缀和处理
        // 拿某一个礼物，只能通过左边或者上边进入，所以第一行只能从左边进入
        for(int i = 1; i < col; i ++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        // 同理，第一列只能从上面进入
        for(int i = 1; i < row; i ++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
