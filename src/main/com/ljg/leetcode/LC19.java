package main.com.ljg.leetcode;

/**
 * 这道题的思路就是快慢双指针，快的先走，慢的指向要删除的结点
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode first = head, second = head, pre = null;
        // 先让first走n个
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            pre = second;
            second = second.next;
        }
        if (second == head) {
            return head.next;
        }
        pre.next = second.next;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

