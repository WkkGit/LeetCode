package leetcode.q136_只现一次的数字_II;

/**
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
/*
    统计所有数字中每个位中1出现的总数，那么对于某个位，1出现的次数一定是3的倍数+1或0，那么对这个数%3得到的结果就是目的数字在该位上的值
 */
public class Solution {
    public int singleNumber(int[] nums) {
        // 存储每一位上1出现的次数，int最长32字节
        int[] counts = new int[32];
        for(int i = 0; i < nums.length; i ++){
            // 数字的每一位都存到对应格子，进行累加
            for(int j = 0; j < 32; j ++){
                // 每一位累加
                counts[j] += nums[i]&1;
                // 右移，进行下一位
                nums[i] >>= 1;
            }
        }
        // 每一位上1出现的次数是3加1次或者0次，即出现三次的数字加上出现一次的数字
        // 所以进行 %3 运算，结果就是出现一次的数字在改位上的值，然后进行恢复即可
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % 3;
        }
        return res;
    }
}
