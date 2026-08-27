class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[52];
        int len = s.length();
        for (char c: t.toCharArray()) {
            count[toI(c)]++;
        }
        int l = 0;
        int minL = Integer.MAX_VALUE;
        String res = "";
        for (int r = 0; r < len; r++) {
            count[toI(s.charAt(r))]--;
            while (l <= r && isInclude(count)){
                if (r - l + 1 < minL) {
                    minL = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                count[toI(s.charAt(l))]++;
                l++;
            }
        }

        return res;
    }

    public boolean isInclude(int[] count) {
        for (int c: count) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }

    public int toI(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= 'A' && c <= 'Z') {
            return (c - 'A') + 26;
        }
        return -1;
    }
}
