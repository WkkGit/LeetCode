package coding_interviews.q04_二维数组中的查找;

/**
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
/*
    因为是有序的，所以可以从左下角开始比对，如果target大，则row减小，如果target小，则col增加

    空间复杂度：O(1)
    时间复杂度：O(n+m)
 */
public class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length-1;
        int col = 0;
        // 从左下角开始做比对
        while(row >= 0 && col < matrix[0].length){
            if(target > matrix[row][col]){
                col ++;
            }else if(target < matrix[row][col]){
                row --;
            }else{
                return true;
            }

        }
        return false;
    }
}
