class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int r = Arrays.stream(piles).max().getAsInt() + 1;
        int sum = Arrays.stream(piles).sum();
        int l = (int) Math.ceil((double)sum / h);

        while (l < r) {
            int m = l + (r - l) / 2;
            int hs = 0;
            for (int p: piles) {
                hs += (int) Math.ceil((double) p / m);
            }
            if (hs > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
