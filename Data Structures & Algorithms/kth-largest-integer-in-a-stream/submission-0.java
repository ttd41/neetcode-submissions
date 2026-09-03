class KthLargest {

    PriorityQueue<Integer> topk;
    int gk;

    public KthLargest(int k, int[] nums) {
        topk = new PriorityQueue<>();
        gk = k;
        for (int n: nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        topk.add(val);
        if (topk.size() > gk) {
            topk.poll();
        }
        return topk.peek();
    }
}
