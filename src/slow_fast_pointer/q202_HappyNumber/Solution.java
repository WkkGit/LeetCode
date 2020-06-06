package slow_fast_pointer.q202_HappyNumber;

/**
    编写一个算法来判断一个数 n 是不是快乐数。如果 n 是快乐数就返回 True ；不是，则返回 False 。
    「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

    示例：

     输入：19
    输出：true
    解释：
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1
 */

/*
    使用“快慢指针”思想找出循环：“快指针”每次走两步，“慢指针”每次走一步，
    当二者相等时，即为一个循环周期。此时，判断是不是因为1引起的循环，是的话就是快乐数，否则不是快乐数。

    注意：此题不建议用集合记录每次的计算结果来判断是否进入循环，
    因为这个集合可能大到无法存储；另外，也不建议使用递归，同理，如果递归层次较深，会直接导致调用栈崩溃。

    空间复杂度：O(1)
    时间复杂度：O(log n)
 */
public class Solution {
    public boolean isHappy(int n) {
        /*
        题中说计算过程中，可能最终会变为1，也可能会进入一个结果不是1的无限循环，
        所以这个题可以理解为判断链表是否存在环。每一步计算的sum就是一个node。
        */
        // 快慢指针都指向头部
        int fast = n;
        int slow = n;
        // slow和fast一开始就是相等的，所以使用do while循环
        do{
            // 满指针走一步
            slow = doCalculate(slow);
            // 快指针走两步
            fast = doCalculate(fast);
            fast = doCalculate(fast);
        }while(slow != fast);

        // 循环结束后，可能slow == fast == 1，也可能是进入无限循环，所以判断slow是否等于1
        return slow == 1;
    }

    // 计算各位上的数字的平方并累加
    public int doCalculate(int n){
        int sum = 0;

        while(n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }
}
