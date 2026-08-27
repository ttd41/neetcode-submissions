class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[52];
        int len = s.length();
        int rem = 0;
        for (char c: t.toCharArray()) {
            if (count[toI(c)] == 0) rem++;
            count[toI(c)]++;
        }
        int l = 0;
        int minL = Integer.MAX_VALUE;
        int start = 0;
        for (int r = 0; r < len; r++) {
            char cr = s.charAt(r);
            count[toI(cr)]--;
            if (count[toI(cr)] == 0) {
                rem--;
            }
            while (rem == 0){
                if (r - l + 1 < minL) {
                    minL = r - l + 1;
                    start = l;
                }
                char cl = s.charAt(l);
                if (count[toI(cl)] == 0) {
                    rem++;
                }   
                count[toI(cl)]++;
                l++;
            }
        }

        return minL == Integer.MAX_VALUE ? "" : s.substring(start, start + minL);
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
