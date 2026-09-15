class Solution {


    public int coinChange(int[] coins, int amount) {
        int minc = dfs(amount, 0, coins);
       return minc == Integer.MAX_VALUE ? -1 : minc;
    }

    public int dfs(int total, int index, int[] coins) {
        if (total == 0) {
            return 0;
        }

        if (index >= coins.length) {
            return Integer.MAX_VALUE;
        }

        int k = coins[index];
        int minCoins = Integer.MAX_VALUE;
        for (int i = total / k; i >= 0; i--) {
            int remc = dfs(total - k * i, index + 1, coins);
            if (remc == Integer.MAX_VALUE) {
                continue;
            }
            minCoins = Math.min(minCoins, i + remc);
        }

        return minCoins;

    }
}
