class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int l = 0, r = intervals.length;
        int len = intervals.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (intervals[m][0] < newInterval[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }   

        boolean added = false;
        for (int i = 0; i < l; i++) {
            temp.add(intervals[i]);
        }
        temp.add(newInterval);
        for (int i = l; i < len; i++) {
            temp.add(intervals[i]);
        }

        List<int[]> res = new ArrayList<>();
        for (int[] i: temp) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < i[0]) {
                res.add(i);
            } else {
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(i[1], last[1]);
            }
        }

        return res.toArray(new int[0][]);

    }
}
