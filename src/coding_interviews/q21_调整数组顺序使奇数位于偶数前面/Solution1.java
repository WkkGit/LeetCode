package coding_interviews.q21_调整数组顺序使奇数位于偶数前面;
/**
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
/*
    使用双指针，从两端开始，因为左边要存奇数，右边要存偶数
    所以左边找到第一个偶数，右边找到第一个奇数，进行交换
    重复扫描，直到左右指针相等

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution1 {
    public int[] exchange(int[] nums) {
        if(nums.length == 0){
            return new int[]{};
        }
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            // 如果是奇数，left 右移
            while(left < right && (nums[left] % 2) == 1){
                left ++;
                continue;
            }
            // 如果是偶数，right 左移
            while(left < right && (nums[right] % 2) == 0){
                right --;
                continue;
            }
            // 如果left指向偶数，right指向奇数，进行交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        return nums;
    }
}
