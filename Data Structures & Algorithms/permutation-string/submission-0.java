class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[] cs = new int[26];
        for (char c: s1.toCharArray()) {
            cs[c - 'a']++;
        }

        for (int r = 0; r < len2; r++) {
            int id = s2.charAt(r) - 'a';
            cs[id]--;
            if (r - len1 >= 0) {
                cs[s2.charAt(r - len1) - 'a']++;
            }
            if (checkAll0(cs)) {
                return true;
            }
        }

        return false;
        
    }

    public boolean checkAll0(int[] cs) {
        for (int n: cs) {
            if (n != 0) return false;
        }
        return true;
    }
}
