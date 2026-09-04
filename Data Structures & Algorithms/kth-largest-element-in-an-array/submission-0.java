class Solution {
    public int findKthLargest(int[] nums, int k) {

        int s = 0, e = nums.length - 1;

        while (s < e) {
            int p = partition(nums, s, e);
            if (p > k - 1) {
                e = p - 1;
            } else if (p < k - 1) {
                s = p + 1;
            } else {
                break;
            }
        }
        

        return nums[k - 1];
    }

    public int partition(int[] nums, int s, int e) {

        if (s == e) {
            return nums[s];
        }

        int pivot = nums[s];
        int i = s + 1, j = e;
        while (i <= j) {
            while (i <= j && nums[i] >= pivot) i++;
            while (i <= j && nums[j] <= pivot) j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }

        int temp = nums[s];
        nums[s] = nums[i - 1];
        nums[i - 1] = temp;


        return i - 1;


    }
}
