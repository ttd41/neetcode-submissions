class Solution {
    public int maxProfit(int[] prices) {
        int min = 100;
        int mprof = 0;
        for (int p: prices) {
            min = Math.min(p, min);
            mprof = Math.max(mprof, p - min);
        }

        return mprof;
    }
}
