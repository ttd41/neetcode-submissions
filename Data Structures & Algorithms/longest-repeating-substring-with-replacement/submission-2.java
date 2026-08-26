class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] counts = new int[26];
        int res = 0, maxFre = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            counts[c]++;
            maxFre = Math.max(maxFre, counts[c]);

            while (i - l + 1 - maxFre > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(i - l + 1, res);
        }

        return res;
    }
}
