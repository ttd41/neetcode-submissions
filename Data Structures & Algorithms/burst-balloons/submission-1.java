class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[] newNum = new int[len + 2];
        int[][] dp = new int[len + 2][len + 2];
        newNum[0] = 1;
        newNum[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            newNum[i + 1] = nums[i];
        }
    

        for (int l = len; l >= 1; l--) {
            for (int r = l; r <= len; r++) {
                for (int i = l; i <= r; i++) {
                    int lastCoin = newNum[l - 1] * newNum[i] * newNum[r + 1];
                    dp[l][r] = Math.max(dp[l][r], lastCoin + dp[l][i - 1] + dp[i + 1][r]);
                }
            }
        }

        return dp[1][len];
    }
}
