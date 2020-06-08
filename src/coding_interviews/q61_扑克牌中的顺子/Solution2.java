package coding_interviews.q61_扑克牌中的顺子;

import java.util.Arrays;

/*
    先排序，排序后记录0的个数，例如，[0,0,3,4,5]，0有两个，那么nums[2]就是当前最小值，
    判断 nums[4] - nums[2] 是否小于 5

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution2 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokers = 0;
        for(int i = 0; i < 4; i ++){
            if(nums[i] == 0){
                // 记录大小王的数量
                jokers ++;
            }else if(nums[i] == nums[i + 1]){
                // 重复直接返回false
                return false;
            }
        }
        return nums[4] - nums[jokers] < 5;
    }
}
