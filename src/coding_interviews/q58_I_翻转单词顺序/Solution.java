package coding_interviews.q58_I_翻转单词顺序;

/**
    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
    为简单起见，标点符号和普通字母一样处理。
    例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
/*
    先分割，再拼接，如果又连续的空格，假如3个，那么这三个空格之间会被切割出一个空串，拼接时要跳过空串
    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution {
    public String reverseWords(String s) {
        // 去除收尾空格，然后按空格切分
        String[] arr = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = arr.length - 1; i >= 0 ; i --){
            // 如果有多个连续空格，分割后可能会含有空字符串，跳过这些空串
            if(arr[i].equals("")){
                continue;
            }
            res.append(arr[i] + " ");
        }

        // 去除最后一次添加时多余的尾部空格
        return res.toString().trim();
    }
}
