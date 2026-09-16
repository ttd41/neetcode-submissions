class Solution {

    // . or i== j dp[i][j] = dp[i - 1][j - 1]
    // * 
    public boolean isMatch(String s, String p) {
        int lp = p.length();
        int ls = s.length();

        char[] cp = p.toCharArray();
        char[] cs = s.toCharArray();


        boolean[][] dp = new boolean[lp + 1][ls + 1];
        dp[0][0] = true;

        for (int i = 0; i < lp; i++) {
            if (cp[i] == '*') {
                dp[i + 1][0] = dp[i - 1][0];
            }
        }

        for (int i = 0; i < lp; i++) {
            for (int j = 0; j < ls; j++) {
                if (cp[i] == cs[j] || cp[i] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (cp[i] == '*' ) {
                    dp[i + 1][j + 1] = dp[i - 1][j + 1];
                    if (cs[j] == cp[i - 1] || cp[i - 1] == '.') {
                        dp[i + 1][j + 1] |= dp[i + 1][j];
                    }
                }
            }
        }

        return dp[lp][ls];
    }



}
