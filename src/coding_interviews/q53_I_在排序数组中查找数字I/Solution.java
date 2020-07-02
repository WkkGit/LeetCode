package coding_interviews.q53_I_在排序数组中查找数字I;

/**
    统计一个数字在排序数组中出现的次数。
 */
/*
    数组已经有序，那么可以使用双指针，找到第一次和最后一次出现的下标，相减即为出现的次数
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == target && nums[right] == target){
                return right - left + 1;
            }
            if(nums[left] < target){
                left ++;
            }
            if(nums[right] > target){
                right --;
            }
        }
        return 0;
    }
}
