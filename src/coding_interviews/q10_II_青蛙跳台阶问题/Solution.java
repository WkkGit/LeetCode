package coding_interviews.q10_II_青蛙跳台阶问题;

/**
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

/*
    斐波那契数列
    空间复杂度：O(n)
    时间复杂度：O(n)
*/
public class Solution {
    public int numWays(int n) {
        if(n <= 1){
            return 1;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n ; i ++){
            result[i] = (result[i-1]+result[i-2])%1000000007;
        }
        return result[n];
    }
}
