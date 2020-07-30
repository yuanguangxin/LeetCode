package 快慢指针遍历.q141_环形链表.f1;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表 o(n)
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
