class Solution {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int minc = dfs(amount, coins.length - 1, coins, dp);
       return minc == Integer.MAX_VALUE ? -1 : minc;
    }

    public int dfs(int total, int index, int[] coins, int[][] dp) {
        if (total == 0) {
            return 0;
        }

        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[index][total] != -1) {
            return dp[index][total];
        }

        int k = coins[index];
        int minCoins = Integer.MAX_VALUE;
        for (int i = total / k; i >= 0; i--) {
            int remc = dfs(total - k * i, index - 1, coins, dp);
            if (remc == Integer.MAX_VALUE) {
                continue;
            }
            minCoins = Math.min(minCoins, i + remc);
        }

        dp[index][total] = minCoins;

        return minCoins;

    }
}
