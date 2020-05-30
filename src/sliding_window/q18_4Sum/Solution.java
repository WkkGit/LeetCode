package sliding_window.q18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，
    判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
    找出所有满足条件且不重复的四元组。

 注意：
        答案中不可以包含重复的四元组。
 */
/*
    这道题和3Sum思路一样，只不过要多一个固定指针，使用两层循环

    空间复杂度：O(1)
    时间复杂度：O(n^2)
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(nums);
        // 处理边界条件
        if(nums == null || nums.length < 4){
            return result;
        }

        int len = nums.length;

        for(int i = 0 ; i < len-3 ; i ++){
            // 去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int k = i+1 ; k < len-2 ; k ++){
                // 去重
                if(k > i+1 && nums[k] == nums[k-1]){
                    continue;
                }

                int L = k + 1;
                int R = len - 1;

                // 优化部分，获取本次循环中的最大的值，如果最大值小于target，那么就可以直接进行下次循环
                int maxSum = nums[i] + nums[k] + nums[R] + nums[R-1];
                if(maxSum < target){
                    continue;
                }
                /*
                    优化部分，获取本次循环中的最大的值，如果最小值大于target，那么就可以直接退出循环
                    因为之后的值只会更大
                */
                int minSum = nums[i] + nums[k] + nums[L] + nums[L+1];
                if(minSum > target){
                    break;
                }

                while(L < R){
                    int sum = nums[i] + nums[k] + nums[L] + nums[R];
                    if(sum == target){
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[k], nums[L], nums[R])));

                        L ++;
                        while(L<R && nums[L] == nums[L-1]){
                            L ++;
                        }
                        // 第一次的时候，R+1会越界，所以要，先减一次再进行判断
                        R --;
                        while(L<R && nums[R] == nums[R+1]){
                            R --;
                        }
                    }else if(sum < target){
                        L ++;
                    }else {
                        R --;
                    }
                }
            }
        }
        return result;
    }
}
