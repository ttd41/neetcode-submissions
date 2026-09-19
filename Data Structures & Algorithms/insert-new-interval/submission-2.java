class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;

        int prevE = -1;
        List<int[]> res = new ArrayList<>();
        boolean isInserted = false;
        for (int[] i: intervals) {
            if (i[0] > prevE) {
                res.add(i);
                prevE = i[1];
            } else {
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(last[1], i[1]);
            }
            if (!isInserted && newInterval[0] <= prevE) {
                int[] prev = res.get(res.size() - 1);
                if (newInterval[0] < prev[0]) {
                    res.remove(res.size() - 1);
                    if (newInterval[1] < prev[0]) {
                        res.add(newInterval);
                        res.add(prev);
                        prevE = prev[1];
                    } else {
                        res.add(new int[]{newInterval[0], Math.max(newInterval[1], prev[1])});
                        prevE = Math.max(newInterval[1], prev[1]);
                    }
                } else {
                    int[] last = res.get(res.size() - 1);
                    last[1] = Math.max(last[1], newInterval[1]);
                    prevE = last[1];
                }
                isInserted = true;
            }
        }

        if (!isInserted) {
            res.add(newInterval);
        }

        return res.toArray(new int[0][]);
    }
}
