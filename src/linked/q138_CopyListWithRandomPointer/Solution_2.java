package linked.q138_CopyListWithRandomPointer;

/*
    先在原链表中进行节点复制，每一个节点的next都是自己的复制
    然后在进行random的设置，最后进行链表拆分
    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution_2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 进行节点复制，每一个复制的节点都是原节点的next，A-A'-B-B' -...
        Node cur = head;
        while(cur != null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        // 对复制节点进行random的设置
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分链表
        cur = head;
        // 新链表的头结点
        Node copy_head = cur.next;
        Node copy_cur = copy_head;
        while(cur != null){
            // 原链表
            cur.next = cur.next.next;
            cur = cur.next;
            // 复制链表
            if(copy_cur.next != null){
                copy_cur.next = copy_cur.next.next;
            } else{
                copy_cur.next = null;
            }
            copy_cur = copy_cur.next;
        }
        return copy_head;
    }
}
