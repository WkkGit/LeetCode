package linked.q138_CopyListWithRandomPointer;

import java.util.HashMap;

/**
    给定一个链表，每个节点包含一个额外增加的随机指针，
    该指针可以指向链表中的任何节点或空节点。
    要求返回这个链表的 深拷贝。
    我们用一个由 n 个节点组成的链表来表示输入/输出中的链表
 */
/*
    使用HashMap，先将所有的节点存入
    （此时存入的节点只是包含节点的值，next和random都不进行关联）
    通过循环，将Map中的所有节点进行关联

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution_1 {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap();
        Node temp = head;
        // 创建节点，存入map，先不做next、random关联
        while(temp != null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        // 将map中的节点进行next与random关联
        while(temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
