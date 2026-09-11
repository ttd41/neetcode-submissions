class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int res = Integer.MAX_VALUE;
        int len = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int curr = Math.min(dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = curr + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
