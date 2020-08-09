package 笔试真题.网易.春招正式批2020;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：
    小易有一个长度为n的数字数组，问你是否能用这n个数字构成一个环(首尾连接)，
    使得环中的每一个数字都小于它相邻的两个数字的和
    (每个数字都必须使用并且每个数字只能使用一次)
    3<= n <= 10^5
    1<= a <= 10^9

 */
public class 数字圆环 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextLong();
            }
            Arrays.sort(nums);
            if((nums[n-2] + nums[n-3]) > nums[n-1]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
