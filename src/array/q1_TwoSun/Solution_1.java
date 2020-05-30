package array.q1_TwoSun;
/**
    题目（easy）:
    给定一个整数数组 nums 和一个目标值 target，
    请你在该数组中找出和为目标值的那 两个 整数，
    并返回他们的数组下标。你可以假设每种输入只会对应一个答案。
    但是，数组中同一个元素不能使用两遍。
 */
/*
    暴力解法：遍历所有元素
    空间复杂度： O(1)
    时间复杂度： O(n^2)
 */
public class Solution_1 {

    public int[] solution_1(int[] nums, int target){

        for(int i = 0; i < nums.length; i ++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == target -nums[j]){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
