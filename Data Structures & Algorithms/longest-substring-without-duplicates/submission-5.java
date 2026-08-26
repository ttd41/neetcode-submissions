class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] lastm = new int[128];
        int l = 0, res = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            l = Math.max(l, lastm[c]);
            res = Math.max(res, i - l + 1);
            lastm[c] = i + 1;
        }

        return res;
    
    }
}
