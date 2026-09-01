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
    public ListNode reverseKGroup(ListNode head, int k) {

        int total = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            total ++;
        }

        
        ListNode l = head, preHead = new ListNode(0, head), lp = preHead;

        for (int j = 0; j < total / k; j++) {
            ListNode prev = null, curr = l;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode n = curr.next;
                curr.next = prev;
                prev = curr;
                curr = n;
            }
            l.next = curr;
            lp.next = prev;
            lp = l;
            l = l.next;
            
        }

        return preHead.next;
        

        
    }
}
