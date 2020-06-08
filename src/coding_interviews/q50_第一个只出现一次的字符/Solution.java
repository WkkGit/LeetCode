package coding_interviews.q50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例:
        s = "abaccdeff"
        返回 "b"
 */
/*
    因为要求返回第一个不重复的元素，那么就可以使用有序的LinkedHashMap，
    元素作为key，boolean标记是否重复来作为value，最后取出第一个为true的元素就是答案
 */
public class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i ++){
            // 如果重复，那么久标记为false
            map.put(c[i], !map.containsKey(c[i]));
        }
        for(int i = 0; i < c.length; i ++){
            // 返回第一个true的元素
            if(map.get(c[i])){
                return c[i];
            }
        }
        // 没有符合结果就返回空
        return ' ';
    }
}
