class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = count1Bit(i);
        }

        return res;
    }

    public int count1Bit(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }
}
