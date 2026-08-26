class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int s = 0, e = len - 1;
        while (s < e) {
            if (numbers[s] + numbers[e] < target) {
                s++;
            } else if (numbers[s] + numbers[e] == target) {
                return new int[]{s + 1, e + 1};
            } else {
                e--;
            }
        }

        return new int[]{0, 0};
    }
}
