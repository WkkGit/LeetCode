package linked.q206_ReverseLinkedList;

/**
    反转一个单链表。
    示例：
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
 */
/*
    双指针，pre作为前一个节点，cur作为当前节点
    每次都将cur.next指向pre节点，最后返回pre
    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution_1 {
    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            // pre和cur前进一位
            pre = cur;
            cur = temp;
        }
        // 最后pre为最终节点，cur为最终节点的next即null，所以返回pre
        return pre;
    }
}
