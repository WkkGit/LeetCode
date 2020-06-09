package coding_interviews.q53_0到n减1中缺失的数字;
/**
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    示例 1:
        输入: [0,1,3]
        输出: 2
 */
/*
    使用二分法，因为是0-n-1，所以每个数字都等于自己的下标
    如果有数字确实，那么它的右侧数字下标肯定不等于自身，
    找到首个不等于自己下标的元素就可以找到缺失的数字

    https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == mid){
                // 如果等于小标，说明左侧没有缺失，检查右半边数组
                left = mid + 1;
            }else{
                // 如果不等于，说明左边出现了缺失，检查左半边数组
                right = mid - 1;
            }
        }
        return left;
    }
}
