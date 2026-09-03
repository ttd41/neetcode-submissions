class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public int lastStoneWeight(int[] stones) {
        for (int s: stones) {
            pq.add(s);
        }

        while (pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(Math.abs(s1 - s2));
        }

        return pq.peek();
    }
}
