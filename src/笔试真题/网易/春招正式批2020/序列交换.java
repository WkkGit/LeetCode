package 笔试真题.网易.春招正式批2020;

import java.util.Arrays;
import java.util.Scanner;

public class 序列交换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++){
            nums[i] = scanner.nextInt();
        }
        SwapArry(nums);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i ++){
            str.append(nums[i] + " ");
        }
        System.out.println(str.toString().trim());
    }

    public static void SwapArry(int[] nums){
        // 全为奇数或全为偶数，根据题目条件，不可以交换，所以不做操作
        if(isAllEven(nums) || isAllOdd(nums)){
            return ;
        }
        // 如果存在奇偶对，则可以排序
        Arrays.sort(nums);

    }

    public static boolean isAllOdd(int[] nums){
        for(int i = 0 ; i < nums.length; i ++){
            if(nums[i] % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAllEven(int[] nums){
        for(int i = 0 ; i < nums.length; i ++){
            if(nums[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
