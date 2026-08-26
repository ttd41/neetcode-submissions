class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> topK = new PriorityQueue<>((a, b) -> freq.getOrDefault(a, 0) - freq.getOrDefault(b, 0));
        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (Integer n: freq.keySet()) {
            int fre = freq.get(n);
            if (topK.size() < k || fre > freq.get(topK.peek())) {
                topK.add(n);
            } 
            if (topK.size() > k) {
                topK.poll();
            }
        }

        return topK.stream().mapToInt(x -> x).toArray();
    }
}
