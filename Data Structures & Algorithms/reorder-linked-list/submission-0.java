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
    public void reorderList(ListNode head) {
        ListNode s = head, f = head;
        int len = 0;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            len ++;
        }

        ListNode p1 = head;
        ListNode p2 = reverse(s);
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode p = prehead;


        for (int i = 0; i < len; i++) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }

        return;
        
    }

    public ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
