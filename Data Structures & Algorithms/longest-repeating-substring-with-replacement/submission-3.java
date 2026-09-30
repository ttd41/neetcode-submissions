class Solution {
    public int characterReplacement(String s, int k) {
        int p1 = 0;
        int p2 = 0;
        int curK = k;
        int maxF = 0;
        int res = 1;
        int[] count = new int[26];
        for (int i = 0, j = 0; j < s.length(); j++) {
        
            int index = s.charAt(j) - 'A';
            count[index]++;
            maxF = Math.max(maxF, count[index]);
            while (j - i + 1 - maxF > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
