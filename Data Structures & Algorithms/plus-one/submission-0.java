class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> num = new ArrayList<>();

        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            num.add(digits[i]);
        }

        int prev = 1;
        List<Integer> res = new ArrayList<>();
        for (int n: num) {
            int curr = (n + prev) % 10;
            res.add(0, curr);
            prev = (n + prev) / 10;
        }

        if (prev != 0) {
            res.add(0, prev);
        }

        int[] resA = new int[res.size()];
        for (int i = 0; i < resA.length; i++) {
            resA[i] = res.get(i);
        }

        return resA;

    }
}
