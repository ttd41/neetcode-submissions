class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] lastm = new int[128];
        int p = 0, l = 0, res = 0;
        for (char c: s.toCharArray()) {
            int last = lastm[c];
            l = Math.max(l, last);
            res = Math.max(p - l + 1, res);
            lastm[c] = p + 1;
            p++;
        }

        return res;
    
    }
}
