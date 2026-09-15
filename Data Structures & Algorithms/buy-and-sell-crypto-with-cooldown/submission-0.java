class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][2];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) { //sell
                    int buy = dp[i + 1][0] - prices[i];
                    int cooldown = dp[i + 1][1];
                    dp[i][1] = Math.max(buy, cooldown);
                } else {
                    int sell = (i + 2 < len) ? dp[i + 2][1] + prices[i] : prices[i];
                    int cooldown = dp[i + 1][0];
                    dp[i][0] = Math.max(sell, cooldown);
                }
            }
        }

        return dp[0][1];
    }
}
