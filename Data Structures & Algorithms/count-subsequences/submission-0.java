class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[lt + 1][ls + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < lt; i++) {
            for (int j = 0; j < ls; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j];
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] += dp[i][j];
                }
            }
        }

        return dp[lt][ls];
    }
}
