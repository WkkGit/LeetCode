package leetcode.q409_最长回文串;

import java.util.HashMap;
import java.util.Map;

/**
    给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
/*
    回文串有两种：
        1.全对称，所有字符都出现偶数次：abba
        2.中间对称，中间字符出现一次，其他出现偶次：abcba

    使用map记录字符出现的次数：
        1.如果出现偶数次，那么这个字符可以全部投入构建
        2.出现奇数次，减1后投入构建（使用偶数个这个字符）

    这样就构建出了全对称的回文串，这时如果数组中元素还有为使用元素，再取一个放在中间构成中间对称
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        // 将String转化为char[]，存入map记录出现次数
        char[] array = s.toCharArray();
        for(char cur : array){
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
        int res = 0;
        // 如果出现偶数次，则可以组成回文，如果出现奇数次，-1之后称为偶数构成回文
        for(char key : map.keySet()){
            int val = map.get(key);
            if(val % 2 == 0){
                res += val;
            }else{
                res += val-1;
            }
        }
        // 最后数组元素没有实用完成，那么在取一个元素放在中间，两边都出现偶数次，中间这个出现一次
        if(res < array.length){
            res += 1;
        }
        return res;
    }
}
