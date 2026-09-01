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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int mid = i + (j - i) / 2;

        return merge2(merge(lists, i, mid), merge(lists, mid + 1, j));
    }


    public ListNode merge2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), p = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            } else if (l2 == null) {
                p.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        return head.next;

    }
}