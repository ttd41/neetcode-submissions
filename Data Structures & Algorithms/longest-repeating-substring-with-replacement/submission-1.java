class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] counts = new int[26];
        int totalCount = 0, res = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            counts[c]++;
            totalCount++;

            while (l < i && totalCount - getMax(counts) > k) {
                counts[s.charAt(l) - 'A']--;
                totalCount--;
                l++;
            }

            res = Math.max(i - l + 1, res);
        }

        return res;
    }

    public int getMax(int[] count) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
