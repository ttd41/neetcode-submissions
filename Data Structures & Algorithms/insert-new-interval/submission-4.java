class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] i: intervals) {
            if (i[0] > newInterval[1]) {
                if (!added)
                    res.add(newInterval);
                res.add(i);
                added = true;
            } else if (i[1] < newInterval[0]) {
                res.add(i);
            } else {
                int[] merged = new int[]{Math.min(i[0], newInterval[0]), Math.max(i[1], newInterval[1])};
                newInterval = merged;
            }
        }

        if (!added) {
            res.add(newInterval);
        }

        return res.toArray(new int[0][]);

    }
}
