class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c: tasks) {
            counts[c - 'A']++;
        }

        Arrays.sort(counts);

        int gapNum = counts[25] - 1;
        int rem = gapNum * n;
        for (int i = 24; i >= 0; i--) {
            rem -= Math.min(gapNum, counts[i]);
        }

        return Math.max(rem, 0) + tasks.length;
    }
}
