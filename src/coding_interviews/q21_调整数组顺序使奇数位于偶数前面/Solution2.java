package coding_interviews.q21_调整数组顺序使奇数位于偶数前面;

/*
    定义快慢双指针 fast 和 low ，fast 在前， low 在后 .
    fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
    fast 向前移动，当它搜索到奇数时，将它和 nums[low] 交换，此时 low 向前移动一个位置 .
    重复上述操作，直到 fast 指向数组末尾 .
    参考链接：
    https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution2 {
    public int[] exchange(int[] nums) {
        int fast = 0;
        int low = 0;
        // 使用low记录当前偶数位置，fast用于搜索奇数，然后将low和fast进行交换
        while(fast < nums.length){
            if(nums[fast] % 2 == 1){
                int temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] =  temp;

                low ++;
            }

            fast ++;
        }
        return nums;
    }
}
