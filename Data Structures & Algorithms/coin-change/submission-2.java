class Solution {

    int minCoins = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int len = coins.length;
        dfs(coins, len - 1, amount, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        
    }

    public void dfs(int[] coins, int idx, int rem, int count) {
        if (rem == 0) {
            minCoins = Math.min(minCoins, count);
        }

        if (idx < 0) return;

        if (count + rem / coins[idx] > minCoins) return;

        for (int k = rem / coins[idx]; k >= 0; k--) {
            if (count + k >= minCoins) break;
            dfs(coins, idx - 1, rem - k * coins[idx], count + k);
        }
    }
}
