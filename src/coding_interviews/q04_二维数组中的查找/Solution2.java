package coding_interviews.q04_二维数组中的查找;

/*
    使用二分查找，从matrix[rowmid][colmid]开始比较，进行二分
    但是时间效率不如方法一，所以不推荐
 */
public class Solution2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int rowMid = matrix.length / 2;
        int colMid = matrix[0].length / 2;
        int row = rowMid;
        int col = colMid ;
        while(row >= 0 && col <matrix[0].length){
            if(target > matrix[rowMid][colMid]){
                rowMid = (rowMid + matrix.length)/2;
                colMid = (colMid + matrix[0].length)/2;
            }else if(target < matrix[rowMid][colMid]){
                rowMid = (rowMid + 1)/2;
                colMid = (colMid + 1)/2;
            }else{
                return true;
            }
        }
        return false;

    }
}
