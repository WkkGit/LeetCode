package slow_fast_pointer.q141_LinkedListCycle;

/*
    快慢指针，如果有环，那么快慢指针在某个时间一定会相遇，如果没有环，那么fast一定最先到达终点

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            // 如果快指针到达尾部，说明没有环
            if(fast == null || fast.next == null){
                return false;
            }
            // 快指针每次走两步，慢指针每次走一步
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
