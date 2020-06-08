package coding_interviews.q39_数组中出现次数超过一半的数字;

/**
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
/*
    摩尔投票法
    初始化： 票数统计 votes = 0 ， 众数 x；
    循环抵消： 遍历数组 nums 中的每个元素 ；
    当票数 votes 等于 0 ，则假设 当前数字 num 为 众数 x ；
    当 num=x 时，票数 votes 增 1 ；否则，票数 votes 减 1 。
    返回值： 返回 众数 xx 即可。

    链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int votes = 0;

        for(int i = 0; i < nums.length; i ++){

            if(votes == 0){
                res = nums[i];
            }
            votes += nums[i] == res ? 1:-1;
        }
        return res;
    }
}
