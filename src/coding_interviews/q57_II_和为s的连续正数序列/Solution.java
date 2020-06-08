package coding_interviews.q57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

    示例 1：
        输入：target = 9
        输出：[[2,3,4],[4,5]]
 */
/*

 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList();
        while(left <= target / 2){
            // 小于目标值，右边界扩大
            if(sum < target){
                sum += right;
                right ++;
            }else if(sum > target){
                // 大于目标值，左边界减小（右移）
                sum -= left;
                left ++;
            }else{
                // 等于目标值，填充元素
                int[] arr = new int[right-left];
                for(int k = left; k < right ; k ++){
                    arr[k-left] = k;
                }
                res.add(arr);

                // 左边界右移，查找下一个符合条件的序列
                sum -= left;
                left ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
