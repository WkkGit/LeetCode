package 笔试真题.京东.秋招提前批2020;

import java.util.Scanner;

/*
题目：
    求f(n)的前n项和，结果保留四位小数
    f(n) = 1/5-1/10 + 1/15-1/20 +...- 1/5*(2*n-1)+1/5*(2*n);

分析：
    1.奇数项为正，偶数项为负
    2.f(n)共有 2n个项
    循环累加，暴力解
 */
public class 前n项和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("%.4f", compute(n));

    }
    private static double compute(int n){
        double res = 0;
        for(int i = 1; i <= 2*n; i ++){
            if((i - 1) % 2 == 0){
                res += 1.0/(5*i);
            }else{
                res -= 1.0/(5*i);
            }
        }
        return res;
    }
}
