class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    
    }
    
    public double findMedian() {
        if (minHeap.size() != maxHeap.size()) {
            return (double) maxHeap.peek();
        }
        return ((double) minHeap.peek() + maxHeap.peek()) / 2;
    }
}
