package 链表操作.q160_相交链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希存储
 *
 * 方法二：两个链表相连，快慢指针判断是否有环（省略）
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
