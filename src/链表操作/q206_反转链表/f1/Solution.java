package 链表操作.q206_反转链表.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力法舍弃空间 o(n)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        ListNode rs = new ListNode(list.get(list.size() - 1));
        ListNode t1 = rs;
        for (int i = list.size() - 2; i >= 0; i--) {
            t1.next = new ListNode(list.get(i));
            t1 = t1.next;
        }
        return rs;
    }
}
