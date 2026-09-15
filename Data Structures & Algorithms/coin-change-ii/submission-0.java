class Solution {
    // 3 -> 1 2, 3, 1 1 1
    // 2 -> 1 1, 2
    // 1 -> 1
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i >= 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }

        return dp[len - 1][amount];
    }
}
