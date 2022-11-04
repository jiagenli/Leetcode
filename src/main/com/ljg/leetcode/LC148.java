package main.com.ljg.leetcode;

public class LC148 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        // 第一次超出时间限制时，是这里报错，让单个节点的next为空
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            // 这里是快慢指针处理的细节
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode middle = slow;
        ListNode left = sort(head, middle);
        ListNode right = sort(middle, tail);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode h = newHead, l = left, r = right;
        while (l != null && r != null) {
            if (l.val < r.val) {
                h.next = l;
                l = l.next;
            } else {
                h.next = r;
                r = r.next;
            }
            h = h.next;
        }
        if (l != null) {
            h.next = l;
        } else if (r != null) {
            h.next = r;
        }
        return newHead.next;
    }

}
