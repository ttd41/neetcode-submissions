class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();

        int maxS = 0;
        for (int[] i: intervals) {
            maxS = Math.max(i[0], maxS);
        }

        int[] maxR = new int[maxS + 1];

        Arrays.fill(maxR, -1);

        for (int[] i: intervals) {
            maxR[i[0]] = Math.max(i[1], maxR[i[0]]);
        }
        int left = -1;
        int right = -1;


        for (int i = 0; i <= maxS; i++) {
            if (maxR[i] != -1) {
                if (left == -1) {
                    left = i;
                }
                right = Math.max(right, maxR[i]);
            }

            if (right == i) {
                res.add(new int[]{left, right});
                left = -1;
                right = -1;
            }
        }

        if (left != -1) {
            res.add(new int[]{left, right});
        }

        return res.toArray(new int[0][]);
    }
}
