package linked.q2_AddTwoNumbers;

/**
    题目(medium):
    给出两个 非空 的链表用来表示两个非负的整数。
    其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
  */

/*
    将两个链表当做同等长度来考虑，在计算时，已经结束的那个链表做0考虑，最后查看最高位是否有进位
    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution {
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            // 判断两个链表是否有一个已经结束
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 判断是否有进位
            carry = sum / 10;
            // 取余得当前节点val
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 查看最高位是否有进位
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return result.next;
    }
}
