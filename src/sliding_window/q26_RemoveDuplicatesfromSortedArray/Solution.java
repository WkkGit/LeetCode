package sliding_window.q26_RemoveDuplicatesfromSortedArray;
/**
 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 你不需要考虑数组中超出新长度后面的元素。

 示例 1:
    给定数组 nums = [1,1,2],
    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 */

/*
    已知条件：
            不需要考虑数组中最后多出来的元素
            已排序的数组
    要求：原地修改

    用 2 个指针，一个在前记作 left，一个在后记作 right，算法流程如下：
        1.比较 left 和 right 位置的元素是否相等。
        2.如果相等，right 后移 1 位
        3.如果不相等，将 right 位置的元素复制到 left+1 位置上，left 后移一位，right 后移 1 位
        4.重复上述过程，直到 right 等于数组长度。
        返回 left + 1，即为新数组长度。

    空间复杂度：O(1)
    时间复杂度：O(n)

    图解：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left] != nums[right]){
                nums[left + 1] = nums[right];
                left ++;
            }
            right ++;
        }
        return left+1;
    }
}
