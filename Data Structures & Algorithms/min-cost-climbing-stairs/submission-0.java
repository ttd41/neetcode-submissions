class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int res = Integer.MAX_VALUE;
        int len = cost.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + cost[i]);
            } 
            if (i + 2 < len) {
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + cost[i]);
            }
            if (i + 1 >= len || i + 2 >= len) {
                res = Math.min(res, dp[i] + cost[i]);
            }
        }

        return res;
    }
}
