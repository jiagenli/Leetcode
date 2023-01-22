package main.com.ljg.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode front = slow, frontPre = null;
        // 查找中间点并反转前半部分
        while (fast != null && fast.next != null) {
            front = slow;
            slow = slow.next;
            fast = fast.next.next;
            front.next = frontPre;
            frontPre = front;
        }

        // 中间节点奇偶数处理
        if (fast != null) {
            slow = slow.next;
        }

        while (front != null || slow != null) {
            if (front == null || slow == null) {
                return false;
            }
            if (front.val != slow.val) {
                return false;
            }
            front = front.next;
            slow = slow.next;
        }
        return true;
    }
}