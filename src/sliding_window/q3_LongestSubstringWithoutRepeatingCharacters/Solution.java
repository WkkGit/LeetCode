package sliding_window.q3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
/*
    滑动窗口，刚开始很难理解，配合画图以及列出每一步步骤会好理解一些
    推荐答案：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/

    定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，
    加 1 表示从字符位置后一个才开始不重复，每次判断元素是否重复，重复就更新start位置，并更新重复元素在map中的下标值

 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap();
        for(int start = 0, end = 0; end < len ; end ++){
            char temp = s.charAt(end);
            // 如果元素已经存在map中，说明重复，更新start的位置
            if(map.containsKey(temp)){
                start = Math.max(map.get(temp), start);
            }
            // 存入元素（或者是更新重复元素下标）
            // 这里存入end+1是为了在更新start的时候方便计算，也可以选择存入end，在更新start的时候再+1
            map.put(s.charAt(end),end+1);
            // 计算最大值，end+1 是因为索引从0开始，所以要加1
            result = Math.max(result,end+1 - start);
        }
        return result;
    }
}
