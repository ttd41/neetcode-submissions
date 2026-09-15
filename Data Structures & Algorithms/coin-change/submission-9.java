class Solution {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = i == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (dp[i][j - coins[i]] + 1));
                }
            }
        }
       return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }


}
