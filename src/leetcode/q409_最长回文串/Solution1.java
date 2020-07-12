package leetcode.q409_最长回文串;

/*
    借助ascii码，定义一个int数组存储每个元素出现的次数
 */
public class Solution1 {
    public int longestPalindrome(String s) {
        // 记录每个字母出现的次数
        // A-65，Z-90，a-97，z-122，Z和a之间隔了6个字符所以 52加6
        int[] count = new int[58];
        for(char cur : s.toCharArray()){
            count[cur - 'A'] += 1;
        }
        int res = 0;
        for(int cnt : count){
            res += cnt - (cnt % 2);
        }
        if (res < s.length()){
            res += 1;
        }
        return res;
    }
}
