class Solution {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int minc = dfs(amount, coins.length - 1, coins);
       return minc == Integer.MAX_VALUE ? -1 : minc;
    }

    public int dfs(int total, int index, int[] coins) {
        if (total == 0) {
            return 0;
        }

        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        int k = coins[index];
        int minCoins = Integer.MAX_VALUE;
        for (int i = total / k; i >= 0; i--) {
            int remc = dfs(total - k * i, index - 1, coins);
            if (remc == Integer.MAX_VALUE) {
                continue;
            }
            minCoins = Math.min(minCoins, i + remc);
        }

        return minCoins;

    }
}
