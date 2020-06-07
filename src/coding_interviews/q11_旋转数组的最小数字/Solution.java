package coding_interviews.q11_旋转数组的最小数字;

/**
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 */
/*
    利用二分法，将中间值和最右侧比较，mid大于right则说明最小值在右侧，查找右半区，否则查找左半区
    https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
 */
public class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else {
                /*
                如果相同，那么最小值可能在左边也可能在右边，例如 1111011
                所以只能慢慢排除和mid重复的右边界，来慢慢查找结果
                */
                right --;
            }

        }
        return numbers[left];
    }
}
