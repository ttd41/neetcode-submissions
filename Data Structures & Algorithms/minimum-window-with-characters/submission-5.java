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

        int minL = Integer.MAX_VALUE;
        int start = 0;
        for (int r = 0, l = 0; r < sl; r++) {
            char c = s.charAt(r);
            if (--counts[c] == 0) {
                re--;
            }

            while (re == 0) {
                if (r - l + 1 < minL) {
                    minL = r - l + 1;
                    start = l;
                }
                if (++counts[s.charAt(l)] == 1) {
                    re++;
                } 
                l++;
            }
        }

        return minL == Integer.MAX_VALUE ? "" : s.substring(start, start + minL);
    }
}
