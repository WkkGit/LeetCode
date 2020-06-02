package sliding_window.q209_MinimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            // 累加当前窗口内的值
            sum += nums[right];
            right++;
            // 如果当前和 >= s
            while (sum >= s) {
                // 判断当前最小长度
                min = Math.min(min, right - left);
                // sum减去当前left的值，保存新窗口中的值，这一步可以省去中间的累加过程
                sum -= nums[left];
                // left右移
                left++;
            }
        }
        // 如果没有结果或者nums为空，那么就返回0
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
