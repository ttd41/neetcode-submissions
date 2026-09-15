class Solution {
    public int maxProfit(int[] prices) {
        // cooldown or not 
        int len = prices.length;
        int[][] dp = new int[len + 1][2];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][0] - prices[i], dp[i + 1][1]);
            dp[i][0] = Math.max((i + 2 <= len ? dp[i + 2][1] : 0) + prices[i], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
