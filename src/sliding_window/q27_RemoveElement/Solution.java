package sliding_window.q27_RemoveElement;

/**
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    示例 :
        给定 nums = [3,2,2,3], val = 3,
        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
        你不需要考虑数组中超出新长度后面的元素。
 */
/*
    这一题的思路和q26是一模一样的，只不过比较条件由 nums[left] != nums[right]变成了nums[right] != val

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;

        int left = 0;
        int right = 0;
        while(right < len){
            if(nums[right] != val){
                nums[left] = nums[right];
                left ++;
            }
            right ++;
        }
        return left;
    }
}
