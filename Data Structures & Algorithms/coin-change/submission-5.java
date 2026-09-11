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
            return;
        }

        if (idx < 0) return;

        if (count + rem / coins[idx] + (rem % coins[idx] != 0 ? 1 : 0) >= minCoins) return;

        int maxK = Math.min(rem / coins[idx], minCoins - count - 1);
        for (int k = maxK; k >= 0; k--) {
            dfs(coins, idx - 1, rem - k * coins[idx], count + k);
        }
    }
}
