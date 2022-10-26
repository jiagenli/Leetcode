package main.com.ljg.leetcode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        // 先找到第一个空的值
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }

        ListNode quick, slow;
        if (a == null) {
            quick = headA;
            slow = headB;
        } else {
            quick = headB;
            slow = headA;
        }
        // 找到领先的步数
        int step = 0;
        ListNode remain = a != null ? a : b;
        while (remain != null) {
            remain = remain.next;
            step++;
        }
        // 让慢指针先走
        for (int i = 0; i < step; i++) {
            slow = slow.next;
        }
        // 找到相交的点
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        return quick;
    }

}
