class Solution {



    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1/x;
        }

        int half = n / 2;
        double v = myPow(x, half);
        if (n > 0) {
            return n % 2 == 1 ? v * v * x : v * v;
        } else {
            return n % 2 == -1 ? v * v * 1/x : v * v;
        }
    }

}
