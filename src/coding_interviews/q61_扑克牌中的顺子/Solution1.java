package coding_interviews.q61_扑克牌中的顺子;

import java.util.HashSet;

/**
    从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    2～10为数字本身，A为1，J为11，Q为12，K为13，
    而大、小王为 0 ，可以看成任意数字。
 */
/*
    由题可知两个条件：1.不能重复，否则不能算为顺子
                    2.大小王可以算作任意数字

    设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：max−min < 5
    例如[0,0,3,4,5]   true

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution1 {
    public boolean isStraight(int[] nums) {
        int max = 0;
        int min = 14;
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i ++){
            // 大小王可以重复，所以不存入set
            if(nums[i] == 0){
                continue;
            }
            // 有重复的元素直接返回false
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        return max-min<5;
    }
}
