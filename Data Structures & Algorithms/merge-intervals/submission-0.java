class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] i: intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < i[0]) {
                res.add(i);
            } else {
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(last[1], i[1]);
            }
        }

        return res.toArray(new int[0][]);
    }
}
