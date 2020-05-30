package sliding_window.q11_ContainerWithMostWater;

/**
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。
 */
/*
    首先，容器的容积 sum = Math.min(ai, an) * (n - i)，即最短的边 * 两边的差 ===》（长乘宽）
    使用双指针（滑动窗口），初始状态时，指向头尾两个数字，每次计算后，都移动最小的边
    比如[1,10,6,8,9,7]，初始时，计算后 sum = 1 * （5-0）= 5，最短边为1，所以左指针后移，第二次最短边为7，又指针前移
    循环计算，终止条件为指针相碰。

    空间复杂度：O(1)
    时间复杂度：O(n)
*/
public class Solution {
    public int maxArea(int[] height) {
        // 初始结果
        int result = -1;
        // 数组长度
        int len = height.length;
        // 定义左右指针，即左右下标
        int left = 0;
        int right = len-1;
        // 只要不想碰，就说明还没有遍历结束
        while(left != right){
            // 计算本次结果
            int sum = Math.min(height[left],height[right]) * (right - left);
            // 与上次进行比较
            result = Math.max(result,sum);
            // 最小的边移动
            if(height[left] > height[right]){
                right --;
            }else{
                left ++;
            }
        }
        return result;
    }
}
