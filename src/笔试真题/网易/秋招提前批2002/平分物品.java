package 笔试真题.网易.秋招提前批2002;

import java.util.Scanner;

/*
题目：
    给了 n 个物品和它对应的价值。可以舍弃一部分物品，
    要两个人平分这些物品（数量可以不一样，价值总和要一样），问最少舍弃多少价值。
    n <= 15
 */
public class 平分物品 {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T -- > 0){
            int n = scanner.nextInt();
            int[] value = new int[n];
            for(int i = 0; i < n; i ++){
                value[i] = scanner.nextInt();
            }

            abandon(value, n-1, 0, 0, 0);
            System.out.println(res);
        }
    }

    public static void abandon(int[] values,int index, int p1, int p2, int value){
        if(index == -1){
            if(p1 == p2 && res > value){
                res = value;
            }
            return ;
        }

        abandon(values, index-1, p1 + values[index],p2,value);
        abandon(values, index-1, p1,p2 + values[index],value);
        abandon(values, index-1, p1,p2,value + values[index]);

    }
}
