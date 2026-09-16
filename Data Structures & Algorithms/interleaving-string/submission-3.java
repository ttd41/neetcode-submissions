class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        char[] ca3 = s3.toCharArray();
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i < l1 && i + j < l3 && ca1[i] == ca3[i + j] && dp[i][j]) {
                    dp[i + 1][j] |= dp[i][j];
                }
                if (j < l2 && i + j < l3 && ca2[j] == ca3[i + j] && dp[i][j]) {
                    dp[i][j + 1] |= dp[i][j];
                }
            }
        }

        return dp[l1][l2];
    }
}
