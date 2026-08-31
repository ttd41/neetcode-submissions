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
    public boolean hasCycle(ListNode head) {

        ListNode f = head, s = head;
        do {
            if (f == null || f.next == null) {
                return false;
            }
            f = f.next.next;
            s = s.next;
        } while (f != s);


        return true;
    }
}
