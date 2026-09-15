class Solution {
    // 3 -> 1 2, 3, 1 1 1
    // 2 -> 1 1, 2
    // 1 -> 1
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int [] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }
}
