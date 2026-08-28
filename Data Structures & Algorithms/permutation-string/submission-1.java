class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[] cs = new int[26];
        int rem = 0;
        for (char c: s1.toCharArray()) {
            if (cs[c - 'a'] == 0)
                rem++;
            cs[c - 'a']++;
        }

        for (int r = 0; r < len2; r++) {
            int rc = s2.charAt(r) - 'a';
            if (--cs[rc] == 0)
                rem--;
            if (r - len1 >= 0) {
                int lc = s2.charAt(r - len1) - 'a';
                if (cs[lc] == 0)
                    rem++;
                cs[lc]++;
            }
            if (rem == 0) {
                return true;
            }
        }

        return false;
        
    }
}
