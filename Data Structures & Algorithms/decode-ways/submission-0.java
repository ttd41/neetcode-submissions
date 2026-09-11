class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int res;
        int dp1 = 1, dp2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int curr = 0;
            if (isValid(s.substring(i, i+1))) {
                curr += dp2;
            }
            if (isValid(s.substring(i-1, i+1))) {
                curr += dp1;
            }
            int temp = dp2;
            dp1 = temp;
            dp2 = curr;
        }
            
        return dp2;
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        if (Integer.valueOf(s) > 26 || Integer.valueOf(s) < 1) return false;
        return true;
    }
}
