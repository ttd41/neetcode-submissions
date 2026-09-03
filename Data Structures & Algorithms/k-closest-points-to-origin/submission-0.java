class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);

    public int[][] kClosest(int[][] points, int k) {
        for (int[] p: points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.toArray(int[][]::new);


    }
}
