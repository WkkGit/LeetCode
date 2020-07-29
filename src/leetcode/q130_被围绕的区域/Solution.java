package leetcode.q130_被围绕的区域;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
/*
    从边界出的O开始向内寻找，并将不能转化的O标记为特殊值，在最后还原即可
 */
public class Solution {
    int row;
    int col;
    public void solve(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }
        row = board.length;
        col = board[0].length;
        // 首先处理四个边界上的'O',都设为特殊值
        for(int i = 0; i < row; i ++){
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        for(int j = 0; j < col; j ++){
            dfs(board, 0, j);
            dfs(board, row-1, j);
        }

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'F'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0 || i>=row || j<0 || j>=col || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'F';
        // 与边界相连的'O'都不能变成'X'，所以置为特殊值
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
