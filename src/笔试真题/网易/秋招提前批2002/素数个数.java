package 笔试真题.网易.秋招提前批2002;

import java.util.Scanner;

/*
题目：
    给一个数组，每一个数都可以拆分，问这个数组最多可以拆分出多少个素数

 分析：
    最小素数是2，这道题相当于：每个元素都除2，求累加结果
 */
public class 素数个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long res = 0;
        int n = scanner.nextInt();
        while(n -- > 0){
            res += scanner.nextInt()/2;
        }
        System.out.println(res);
    }
}
