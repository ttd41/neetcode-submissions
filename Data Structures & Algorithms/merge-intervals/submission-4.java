class Solution {
    public int[][] merge(int[][] intervals) {
        int maxR = 0;
        for (int[] i: intervals) {
            maxR = Math.max(maxR, i[1]);
        }

        int[] mp = new int[maxR + 1];
        boolean[] bp = new boolean[maxR + 1];

        for (int[] i: intervals) {
            mp[i[0]]++;
            mp[i[1]]--;
            bp[i[0]] = true;
        }

        int left = -1;
        int right = -1;
        int balance = 0;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i <= maxR; i++) {
            if (balance == 0 && (mp[i] > 0 || bp[i])) {
                left = i;
            } 

            balance += mp[i];

            if (balance == 0 && left != -1) {
                right = i;
                res.add(new int[]{left, right});
                left = -1;
                right = -1;
            }
            
        }

        return res.toArray(new int[0][]);
    }
}
