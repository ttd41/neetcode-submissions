class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    count++;
                    dp[i][j] = true;
                }
            }
        }

        return count;
        
    }
}
