package tencent50.q14_最长公共前缀;

import java.util.Arrays;

/**
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
 */
/*
    1.将数组排序
    2.第一个元素和最后一个元素进行比较，返回公共部分即可
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        Arrays.sort(strs);
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        int left = strs[0].length();
        int right = strs[len-1].length();
        int border = Math.min(left, right);
        for(int i = 0; i < border; i ++){
            if(strs[0].charAt(i) == strs[len-1].charAt(i)){
                res.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return res.toString();
    }
}