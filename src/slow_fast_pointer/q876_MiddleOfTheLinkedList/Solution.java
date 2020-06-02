package slow_fast_pointer.q876_MiddleOfTheLinkedList;

/**
 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 如果有两个中间结点，则返回第二个中间结点。

 */
/*
    使用快慢指针，快指针每次走两步，慢指针走一步，当快指针到达尾部时，满指针刚好停在中间

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针求链表中间值
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
