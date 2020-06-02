package slow_fast_pointer.q141_LinkedListCycle;

import java.util.HashSet;

/**
    给定一个链表，判断链表中是否有环。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

    示例：
        输入：head = [1], pos = -1
        输出：false
        解释：链表中没有环。
 */
/*
    使用HashSet的唯一性，遍历节点的时候将节点存入，如果在遍历过程中发现有已经存入的元素，那么就说明有环出现

    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        // HashSet存储
        HashSet set = new HashSet();
        if(head == null || head.next == null){
            return false;
        }
        while(head.next != null){
            // 如果set中已经存储过当前这个节点，那么就说明有环
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
