class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        boolean[][][] dp = new boolean[l1 + 1][l2 + 1][l3 + 1];
        dp[0][0][0] = true;
        
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        char[] ca3 = s3.toCharArray();
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                for (int k = 0; k <= l3; k++) {
                    if (i < l1 && k < l3 && ca1[i] == ca3[k] && dp[i][j][k]) {
                        dp[i + 1][j][k + 1] = true;
                    }
                    if (j < l2 && k < l3 &&ca2[j] == ca3[k] && dp[i][j][k]) {
                        dp[i][j + 1][k + 1] = true;
                    }
                }
            }
        }

        return dp[l1][l2][l3];
    }
}
