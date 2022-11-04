package main.com.ljg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC142 {
    /**
     * 这是我的做法，用set来做，并没有完全符合O(1)空间复杂度的需求
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
