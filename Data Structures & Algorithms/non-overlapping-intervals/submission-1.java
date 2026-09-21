class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        int prev = Integer.MIN_VALUE;
        int removed = 0;
        for (int[] i: intervals) {
            if (i[0] < prev) {
                removed++;
                prev = Math.min(prev, i[1]);
                continue;
            } else {
                prev = i[1];
            }
        }

        return removed;
    }
}
