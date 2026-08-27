class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[] counts = new int[128];
        int re = 0;
        for (char c: t.toCharArray()) {
            if (counts[c] == 0) {
                re++;
            }
            counts[c]++;
        }

        String res = "";
        for (int r = 0, l = 0; r < sl; r++) {
            char c = s.charAt(r);
            if (--counts[c] == 0) {
                re--;
            }

            while (re == 0) {
                if (res.equals("") || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
                if (++counts[s.charAt(l)] == 1) {
                    re++;
                } 
                l++;
            }
        }

        return res;
    }
}
