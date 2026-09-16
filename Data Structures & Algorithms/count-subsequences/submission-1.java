class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[] dp = new int[lt + 1];
        dp[0] = 1;
        
        for (int j = 0; j < ls; j++) {
            for (int i = lt - 1; i >= 0; i--) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1] += dp[i];
                }
            }
        }

        return dp[lt];
    }
}
