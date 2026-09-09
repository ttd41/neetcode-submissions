class Solution {
    List<String> res = new ArrayList<>();
    Map<String, PriorityQueue<String>> hm = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        String start = "JFK";
        for (List<String> t: tickets) {
            String from = t.get(0);
            String to = t.get(1);
            hm.computeIfAbsent(from, k -> new PriorityQueue<>((a, b) -> a.compareTo(b))).add(to);
        }

        dfs(start);
        return res;
    }

    public void dfs(String start) {
        PriorityQueue<String> pq = hm.get(start);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }

        res.add(0, start);
    }


}
