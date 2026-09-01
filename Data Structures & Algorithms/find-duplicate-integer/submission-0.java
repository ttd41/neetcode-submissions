class Solution {
    public int findDuplicate(int[] nums) {
        int s = 0;
        int f = 0;

        do {
            s = nums[s];
            f = nums[nums[f]];

        } while (s != f);

        int s2 = 0;
        do {
            s = nums[s];
            s2 = nums[s2];

        } while (s != s2);

        return s;
    }
}
