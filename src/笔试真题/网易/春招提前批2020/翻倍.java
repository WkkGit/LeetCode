package 笔试真题.网易.春招提前批2020;

import java.util.Scanner;

/*
题目：
    给定数字A，B (A<B)和系数p，q。（1 <= A, p,B <= 10^9，2 <= q <= 10，1<= T <=5.）
    每次操作可以选择将A变成 A+p 或者将 p 变成 p*q。求至少几次操作使得 B <= A

分析：
    这题就是要找到使A增加最快的方式，
    因为 A+P是线性增长，而 p *= q，A+p是倍增，所以：
        如果 A + p >= B直接满足，那么就走这一步
        否则就走 p = p * q，因为q肯定>=2
 */
public class 翻倍 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            long A = in.nextLong();
            int B = in.nextInt();
            long p = in.nextLong();
            int q = in.nextInt();
            int count = 0;
            while(A < B){
                if(A + p >= B){
                    A = A + p;
                }else{
                    p = p * q;
                }
                count ++;
            }
            System.out.println(count);
        }
    }
}
