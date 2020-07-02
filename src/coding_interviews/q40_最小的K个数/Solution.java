package coding_interviews.q40_最小的K个数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
    输入整数数组 arr ，找出其中最小的 k 个数。
    例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
/*
    TOP K问题，最小K个数用大根堆，最大K个数用小根堆
    遍历数组，个数小于K时，直接添加入堆，大于K时，与堆顶元素比较，留下较小的
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0){
            return new int[0];
        }
        // PriorityQueue默认是小根堆，所以要传入自定义比较器改为大根堆
        Queue<Integer> queue = new PriorityQueue(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        });
        for(int num : arr){
            if(queue.size() < k){
                queue.offer(num);
            }else if(queue.peek() > num){
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        for(int i = 0 ; i < k; i ++){
            res[i] = queue.poll();
        }
        return res;
    }
}