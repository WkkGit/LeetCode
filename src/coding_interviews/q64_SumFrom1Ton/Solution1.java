package coding_interviews.q64_SumFrom1Ton;

/**
    求 1+2+...+n ，
    要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

/*
    因为不能使用乘除法以及判断语句，那么可以考虑利用逻辑运算符&&的短路特性来作为条件
    当 && 前半部分为true时，后半部分才会运算。因此在 && 前面的表达式就可以作为递归出口
    后面的就是真正的累加过程

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution1 {
    public int sumNums(int n) {
        int sum = n;
        // (sum += sumNums(n-1)) > 0这里判断大于0只是为了让其成为一个boolean表达式，真正目的还是执行sum += sumNums(n-1)
        boolean flag = n > 0 && (sum += sumNums(n-1)) > 0;
        return sum;
    }
}
