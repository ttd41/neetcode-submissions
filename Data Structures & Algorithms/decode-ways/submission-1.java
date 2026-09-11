class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int res;
        int dp1 = 1, dp2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int curr = 0;
            int d1 = s.charAt(i - 1);
            int d2 = s.charAt(i);
            if (d2 != '0') {
                curr += dp2;
            }
            if (d1 == '1' || d1 == '2' && d2 >= '0' && d2 <= '6') {
                curr += dp1;
            }
            int temp = dp2;
            dp1 = temp;
            dp2 = curr;
        }
            
        return dp2;
    }
}
