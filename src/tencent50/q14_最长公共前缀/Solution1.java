package tencent50.q14_最长公共前缀;

/*
    依次比较，保留公共部分
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int len = strs.length;
        String res = strs[0];
        for(int i = 1; i < len; i ++){
            int temp = Math.min(res.length(), strs[i].length());
            int k = 0;
            for(; k < temp ; k ++){
                if(strs[i].charAt(k) != res.charAt(k)){
                    break;
                }
            }
            res = res.substring(0,k);
        }
        return res;
    }
}
