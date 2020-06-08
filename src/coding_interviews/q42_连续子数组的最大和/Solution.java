package coding_interviews.q42_连续子数组的最大和;

/**
    输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 

    示例1:
        输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
/*
    参考答案
    https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i ++){
            // 如果和之前的和大于0，继续累加
            if(sum > 0){
                sum += nums[i];
            }else if(sum <= 0){
                // 如果之前的和小于0，那么累加必定使结果变小，所以抛弃之前的和
                sum = nums[i];
            }
            // 每次都保存当前最大值
            result = Math.max(result,sum);
        }
        return result;
    }
}
