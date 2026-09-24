class CountSquares {

    Map<Integer, Map<Integer, Integer>> counts;

    public CountSquares() {
        counts = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        counts.putIfAbsent(x, new HashMap<>());
        counts.get(x).put(y, counts.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if (!counts.containsKey(x1)) return res;

        for (int y2: counts.getOrDefault(x1, new HashMap<>()).keySet()) {

            if (y2 == y1) continue;

            int diff = y2 - y1;
            int x3 = x1 + diff, x4 = x1 - diff;

            res += counts.get(x1).get(y2) * 
                counts.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0) * 
                counts.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);
            res += counts.get(x1).get(y2) * 
                counts.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0) * 
                counts.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }

        return res;
    }
}
