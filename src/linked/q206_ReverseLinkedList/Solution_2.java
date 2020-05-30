package linked.q206_ReverseLinkedList;

/*
    递归方式，每次都把head的next节点的next指向head
    该方法不是很好理解，可以根据逻辑画图进行理解

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution_2 {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        /*
            经过递归调用后，lastNode是最后一个节点，即新的头结点
            在每一层返回的过程中，都会将该层节点的指向进行反转
         */
        ListNode lastNode = reverse(head.next);
        // head的next节点的next指向head，即反转：A-B ===> B-A
        head.next.next = head;
        // 反转后将head.next置空
        head.next = null;

        return lastNode;
    }
}
