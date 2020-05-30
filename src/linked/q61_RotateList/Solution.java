package linked.q61_RotateList;

/**
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
     向右旋转 1 步: 5->1->2->3->4->NULL
     向右旋转 2 步: 4->5->1->2->3->NULL

 */
/*
    其实就是将后面的指定个数节点移至链表前面
    先遍历得到链表的长度，然后首尾相连，
    接着计算出新的尾结点和头结点，尾结点：倒数第k+1，头结点：倒数第k
    断开新头尾节点，返回头结点
    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = 1;
        ListNode temp = head;
        // 计算长度
        while(temp.next != null){
            length ++;
            temp = temp.next;
        }
        // 首尾想连
        temp.next = head;
        temp = head;
        // 计算倒数第k+1个节点，即新的尾结点
        // k%length 是在k大于length时也能得到有效结果
        int step = length - k % length - 1;
        while(step >0){
            temp = temp.next;
            step --;
        }
        // 倒数第k+1的下一个节点就是新的头结点，即倒数第k个节点
        head = temp.next;
        // 将新的尾结点和头结点断开
        temp.next = null;

        return head;

    }
}
