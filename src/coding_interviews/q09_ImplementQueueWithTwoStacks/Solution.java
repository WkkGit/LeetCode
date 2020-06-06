package coding_interviews.q09_ImplementQueueWithTwoStacks;

import java.util.Stack;
/**
    用两个栈实现一个队列。队列的声明如下，
    请实现它的两个函数 appendTail 和 deleteHead ，
    分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */

public class Solution {
    class CQueue {
        // 用于存储入队列元素
        private Stack<Integer> stack1;
        // 用于辅助出队列
        private Stack<Integer> stack2;
        // 记录当前元素个数
        int size;

        public CQueue() {
            // 初始化
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            size = 0;
        }

        public void appendTail(int value) {
            stack1.push(value);
            size ++;
        }

        public int deleteHead() {
            if(size == 0){
                return -1;
            }

            // 将stack1中的元素倒入stack2中，这样每次删除的时候，只需要stack2进行pop就可以
            // 当stack2为空的时候，说明之前的元素已经全部删除，再将stack1的元素倒入stack2中
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            size --;
            return stack2.pop();
        }

        /*
        // 这种方式每次都要再把元素放回stack1，比较耗时，上面方式是优化后的，更可取
        public int deleteHead() {
            if(size == 0){
                return -1;
            }

            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            int temp = stack2.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            size --;
            return temp;
        }
        */
    }
}
