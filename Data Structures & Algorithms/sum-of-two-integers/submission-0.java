public class Solution {
    public int getSum(int a, int b) {
        int carry = 0, res = 0, mask = 0xFFFFFFFF;
        int pointer = 1;

        while (pointer != 0) {
            int a_bit = a & 1;
            int b_bit = b & 1;
            int cur_bit = a_bit ^ b_bit ^ carry;
            int has = a_bit | b_bit | carry;
            int all = a_bit & b_bit & carry;
            carry = (all == 1 || (cur_bit == 0 && has == 1)) ? 1 : 0;
            if (cur_bit != 0) {
                res |= pointer;
            }

            pointer <<= 1;
            a >>>= 1;
            b >>>= 1;
        }


        return res;
    }
}