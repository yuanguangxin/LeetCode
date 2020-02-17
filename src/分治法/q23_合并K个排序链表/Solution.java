package 分治法.q23_合并K个排序链表;

/**
 * 做k-1次mergeTwoLists  o(N*k) 可用分治法优化至o(N*log(k))) N为所有list的总节点数
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = l1;
        ListNode pre = head;
        while (l2 != null) {
            ListNode t1 = pre.next;
            ListNode t2 = l2.next;
            while (l2.val > t1.val) {
                if (t1.next == null) {
                    t1.next = l2;
                    return head.next;
                } else {
                    pre = pre.next;
                    t1 = t1.next;
                }
            }
            pre.next = l2;
            l2.next = t1;
            l2 = t2;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
}
