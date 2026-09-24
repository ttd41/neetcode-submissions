class Solution {
    public int reverseBits(int n) {
        
        int res = 0;

        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                res |= 1;
            }
            res <<= 1;
            n >>= 1;
        }

        if ((n & 1) == 1) {
            res |= 1;
        }
        return res;
    }
}
