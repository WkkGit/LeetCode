package sliding_window.q15_3Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
    给你一个包含 n 个整数的数组 nums，
    判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。
 */
/*
    首先对数组进行排序，排序后，如果第一个元素就大于0，那么后面肯定就不会出现想要的结果
    对于重复元素：跳过，避免出现重复解
    令左指针 L=i+1，右指针 R=n-1，当 L<RL<R 时，执行循环：
    当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。同时将 L,R 移到下一位置，寻找新的解
    若和大于 0，说明 nums[R] 太大，R 左移
    若和小于 0，说明 nums[L] 太小，L 右移

    空间复杂度：O(1)
    时间复杂度：O(n^2)
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        int len = nums.length;
        // 如果排序后第一个元素就大于0，那就肯定不存在和为0的三个数，直接返回
        Arrays.sort(nums);
        if(nums == null || len < 3 || nums[0] > 0){
            return result;
        }

        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0){
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            // i>0 是为了不让第0个元素进行判断时出现越界异常
            if(i > 0 && nums[i] == nums[i-1]){
                continue; // 去重
            }
            int L = i+1;
            int R = len-1;

            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]){
                        // 去重，直接指向最后一个重复元素，比如 -1，-1，-1，0，直接让L指向第三个-1，所以去重后还需要再++
                        L++;
                    }
                    L++;
                    // 去重，原理同上
                    while (L<R && nums[R] == nums[R-1]){
                        R--;
                    }
                    R--;
                } else if (sum < 0){
                    // 小于0说明左边的值太小，后移取大一些的，这里不需要去重是因为，值相同意味着sum依旧小于0，不会对最终结果有影响
                    L++;
                } else if (sum > 0){
                    // 大于0说明右边的值太大，前移取小一些的
                    R--;
                }
            }
        }
        return result;
    }
}
