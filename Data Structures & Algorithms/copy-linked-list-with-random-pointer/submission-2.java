/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node ram = p.random;
            Node n = new Node(p.val);
            p.random = n;
            n.next = ram;
            p = p.next;
        }

        Node newHead = head.random;
        p = head;
        while (p != null) {
            Node n = p.random;
            if (n.next != null) {
                n.random = n.next.random;
            }
            p = p.next;
        }

        p = head;
        while (p != null) {
            Node n = p.random;
            p.random = n.next;
            if (p.next != null) {
                n.next = p.next.random;
            } else {
                n.next = null;
            }
            p = p.next;
        }

        return newHead;
    }
}
