class Solution {
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = nextNumber(n);

        while (slow != fast) {
            slow = nextNumber(slow);
            fast = nextNumber(fast);
            fast = nextNumber(fast);
        }

        return fast == 1;
    }

    public int nextNumber(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
