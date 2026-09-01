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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        ListNode f = preHead;
        preHead.next = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }

        ListNode s = preHead;
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        s.next = s.next.next;

        return preHead.next;
    }
}
