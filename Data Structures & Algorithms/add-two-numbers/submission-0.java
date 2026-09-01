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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p1 = l1, p2 = l2, p = head;
        int prev = 0;
        while (p1 != null || p2 != null || prev != 0) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;

            int v = (v1 + v2 + prev) % 10;
            prev = (v1 + v2 + prev) / 10;

            ListNode ln = new ListNode(v);
            p.next = ln;

            p = p.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            
        }

        return head.next;
    }
}
