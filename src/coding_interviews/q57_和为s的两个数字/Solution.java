package coding_interviews.q57_和为s的两个数字;

import java.util.HashMap;
import java.util.Map;

/**
    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[2,7] 或者 [7,2]
 */
/*
    这题和leetcode的第一题一样
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key = 元素 value = 下标;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            int temp = target - nums[i];
            // 判断是否存在与之配对的数，且该数不能是他自己
            if(map.containsKey(temp) && map.get(temp) != i){
                return new int[]{temp,nums[i]};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
