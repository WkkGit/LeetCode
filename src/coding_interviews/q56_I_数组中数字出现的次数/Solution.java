package coding_interviews.q56_I_数组中数字出现的次数;

/**
    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
    要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
/*
    异或运算
        第一次全组异或，得到res1 和 res2 的异或值 temp
        根据异或值，找到两个数字的第一个不同位：temp&(-temp)
        根据不同位，将数组分为两部分
            第一部分：不同位为1且出现两次的数字，不同位为1且出现一次的数字
            第二部分：不同位为0且出现两次的数字，不同位为0且出现一次的数字
        两个部分分别异或，得到最终结果
    https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/meng-xin-xiang-wo-zi-ji-jiu-shi-meng-xin-yan-jiu-l/
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int [2];
        // 全员异或后，得到两个出现一次数字的异或值
        int temp = 0;
        for(int i : nums){
            temp ^= i;
        }
        // 根据异或值，找到第一个为1的最低位，公式为：n&-n
        /*
            因为异或运算不同才为1，所以找到他们的第一个不同的位，通过这个将数组分为两部分
            第一部分：不同位为1且出现两次的数字，不同位为1且出现一次的数字
            第二部分：不同位为0且出现两次的数字，不同位为0且出现一次的数字
            两个部分分别异或就能获得两个出现一次的数字
         */
        int flag = temp&(-temp);
        for(int i: nums){
            // 不同位为0,
            if((i & flag) == 0){
                res[0] ^= i;
            }else{
                // 不同位为1
                res[1] ^= i;
            }
        }
        return res;
    }
}
