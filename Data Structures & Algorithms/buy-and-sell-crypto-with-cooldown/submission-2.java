class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][3];
        // 0 rest 1 hold 2 sell
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = dp[i - 1][1] + prices[i];
            }
        }

        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
