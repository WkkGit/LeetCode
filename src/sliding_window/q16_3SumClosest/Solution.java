package sliding_window.q16_3SumClosest;

import java.util.Arrays;

/**
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    找出 nums 中的三个整数，使得它们的和与 target 最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。

    示例：
        给定数组 nums = [-1，2，1，-4], 和 target = 1.
        与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 */
/*
    这道题的框架和3Sum大致一样，选择一个固定的位置，然后移动另外两个，
    只是需要每次通过差值的绝对值来比较哪次结果更接近target
    在循环过程中，如果出现 sum = target的情况，那么就可以直接返回，因为相等差值为0 永远最小

    空间复杂度：O(1)
    时间复杂度：O(n^2)
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        if(nums == null || len < 3){
            return -1;
        }
        Arrays.sort(nums);
        // 选择一个初始值，如果是自己设定的话，在循环判断的过程中，可能会影响结果
        int result = nums[0]+nums[1]+nums[2];
        int temp_abs =  Math.abs(result - target);

        // i = len-2 是因为，如果i为倒数第一和倒数第二个数字时， L肯定是大于等于R，所以可以直接跳过，不执行
        for(int i = 0 ; i < len-2 ; i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                // 计算差值的绝对值
                int temp = Math.abs(sum - target);
                // 通过差值的绝对值来比较哪次结果更接近 ，保存最接近的结果
                if(temp_abs > temp){
                    temp_abs = Math.min(temp_abs, temp);
                    result = sum;
                }

                if(sum > target){
                    // sum 大于target，R前移，sum减小些
                    R --;
                }else if(sum < target){
                    // sum 小于target，L后移，sum增大些
                    L ++;
                }else {
                    // 两者相等，差值为0 最小，直接返回
                    return result;
                }
            }
        }

        return result;
    }
}
