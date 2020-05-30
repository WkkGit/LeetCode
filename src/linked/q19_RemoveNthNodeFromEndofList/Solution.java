package linked.q19_RemoveNthNodeFromEndofList;
/**
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */

/*
    使用双指针来进行删除，让fast指针先走 n + 1 步，然后fast和slow指针同时走，
    当fast走到最后一个时，slow正好是倒数第N个节点
    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚节点作为头结点，以避免删除头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && n+1 > 0){
            fast = fast.next;
            n --;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 如果fast == null 那么头结点就是倒数第N个
        slow.next = slow.next.next;

        return dummy.next;
    }
}
