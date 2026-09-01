class LRUCache {

    class Node {
        int val;
        int key;
        Node next;
        Node prev;

        Node (int key, int val) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        
        Node node = hm.get(key);
        remove(node);
        insertToFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (!hm.containsKey(key)) {
            if (hm.size() == cap) {
                Node removed = tail.prev;
                remove(removed);
                hm.remove(removed.key);
            }
            Node n = new Node(key, value);
            hm.put(key, n);
            insertToFront(n);
        } else {
            Node n = hm.get(key);
            n.val = value;
            remove(n);
            insertToFront(n);
        }
    }


    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null;
        n.next = null;
    }

    public void insertToFront(Node n) {
        n.next = head.next;
        head.next = n;
        n.prev = head;
        n.next.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */