class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        int res = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            res = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = res;
        }

        return dp[1];
    }
}
