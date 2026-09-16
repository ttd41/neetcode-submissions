class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[] newNum = new int[len + 2];
        int[][] dp = new int[len + 2][len + 2];

        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        newNum[0] = 1;
        newNum[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            newNum[i] = nums[i - 1];
        }
        

        return dfs(1, len, newNum, dp); 
    }

    public int dfs(int l, int r, int[] newNum, int[][] dp) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }


        int res = 0;
        for (int i = l; i <= r; i++) {
            int lastCoin = newNum[l - 1] * newNum[i] * newNum[r + 1];
            res = Math.max(res, lastCoin + dfs(l, i - 1, newNum, dp) + dfs(i + 1, r, newNum, dp));
        }

        dp[l][r] = res;

        return res;

    }
}
