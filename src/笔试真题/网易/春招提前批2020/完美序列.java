package 笔试真题.网易.春招提前批2020;

import java.util.Scanner;

/*
题目：
    小易定义一个数字序列是完美的，当且仅当对于任意2 <= i <= n2≤i≤n，
    都满足每个数字都要大于等于前面所有数字的和。
    现在给定数字序列，小易想请你从中找出最长的一段连续子序列，满足它是完美的。

 分析：
    双指针滑动窗口
 */
public class 完美序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        while(times -- > 0){
            int size = scanner.nextInt();
            int[] nums = new int[size];
            for(int i = 0 ; i < size; i ++){
                nums[i] = scanner.nextInt();
            }
            System.out.println(longestSub(nums));
        }
    }

    private static int longestSub(int[] nums){
        int left = 0, right = 1, max = 0, sum = nums[0], len = nums.length;
        while(right < len) {
            // 大于等于之前的和，满足完美序列条件，继续扩大右边界
            if(nums[right] >= sum) {
                sum += nums[right];
                max = Math.max(max, right - left +1);
                right ++;
            } else {
                // 不满足，缩小左边界
                sum -= nums[left];
                left ++;
            }
        }
        return max;
    }
}
