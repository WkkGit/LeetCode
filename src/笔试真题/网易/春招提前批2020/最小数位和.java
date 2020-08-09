package 笔试真题.网易.春招提前批2020;

import java.util.Scanner;

/*
题目：
    定义S(n)，表示n在十进制下的各位数字和。
    现在给定一个x,请你求出最小正整数n，满足x <= S(n)

 分析：
    每个数位上的数最大到9，所以就是看9的个数。
    比如 28 = 3 x 9 +1，结果就是1999
    26 = 2 x 9 +8，结果就是899
 */
public class 最小数位和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入数字个数
        int T = scanner.nextInt();
        for(int i = 0; i < T; i ++){
            int x = scanner.nextInt();
            System.out.println(compute(x));
        }
    }
    private static String compute(int x){
        // 9的个数
        int count = x / 9;
        // 计算最高位
        int h = x % 9;
        StringBuilder res = new StringBuilder();
        if(h != 0){
            res.append(h);
        }
        for(int i = 0; i < count ; i ++){
            res.append("9");
        }
        return res.toString();
    }
}
