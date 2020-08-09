package 笔试真题.京东.秋招提前批2020;

import java.util.Scanner;

/*
题目：
    一个数（1<= n <= 1000000），当我们取出这个数其中一位后，他能构成一个回文素数（即是回文数，也是素数,
    处理后仅有一位的数也可以是回文素数，如3,5,7)
    输入N，M，求在[N,M]范围内满足该条件的数字的个数

分析：
    1.素数定义：只有1和本身两个因数
    2.10的整数倍肯定不可能满足回文
 */
public class 回文素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int count = 0;
        for(int i = N; i <= M; i ++){
            if(judge(i)){
                count ++;
            }
        }
        System.out.println(count);
    }
    private static boolean judge(int n){
        Integer temp = n;
        int temp2;
        char[] chars = temp.toString().toCharArray();
        for(int i = 0; i < chars.length; i ++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < chars.length; j ++){
                if(j != i) stringBuilder.append(chars[j]);
            }
            temp2 = Integer.valueOf(stringBuilder.toString());
            if(isHW(temp2) && isPrim(temp2)){
                return true;
            }
        }
        return false;
    }
    private static boolean isHW(int n){
        if(n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }
        // target是n反过来的数字
        int target = 0;

        Integer temp = n;
        char[] chars = temp.toString().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >= 0 ; i --){
            stringBuilder.append(chars[i]);
        }
        target = Integer.valueOf(stringBuilder.toString());
        return n == target;
    }
    private static boolean isPrim(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i < n/2 + 1; i ++){
            if(n % i ==0){
                return false;
            }
        }
        return true;
    }
}
