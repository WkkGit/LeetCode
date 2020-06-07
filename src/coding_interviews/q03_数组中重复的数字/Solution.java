package coding_interviews.q03_数组中重复的数字;

import java.util.HashSet;
/**
    找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
/*
    利用HashSet或者HashMap来进行元素存储，如果已经有相同元素，说明重复，直接返回

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        int result = -1;
        HashSet<Integer> set = new HashSet();
        for(int i = 0 ; i < nums.length ; i ++){
            if(set.contains(nums[i])){
                result = nums[i];
                break;
            }
            set.add(nums[i]);
        }

        return result;
    }
}
