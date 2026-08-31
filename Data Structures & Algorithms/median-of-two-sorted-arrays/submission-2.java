class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        // 1, 1
        // 2, 3
        // 2, 4

        int l = 0, r = len1;

        while (l <= r) {
            int m =  l + (r - l) / 2;
            int l1 = m - 1;
            int r1 = l1 + 1;
            int l2 = (len1 + len2) / 2 - l1 - 2;
            int r2 = l2 + 1;
            int lv1 = l1 >= 0 ? nums1[l1] : Integer.MIN_VALUE;
            int rv1 = r1 < len1 ? nums1[r1] : Integer.MAX_VALUE;
            int lv2 = l2 >= 0 ? nums2[l2] : Integer.MIN_VALUE;
            int rv2 = r2 < len2 ? nums2[r2] : Integer.MAX_VALUE;

            if (lv1 <= rv2 && lv2 <= rv1) {
                if ((len1 + len2) % 2  == 1){
                    return (double) Math.min(rv1, rv2);
                } else {
                    return ((double) Math.max(lv1, lv2) + Math.min(rv1, rv2)) / 2;
                }
            } else if (lv1 > rv2) {
                r = m;
            } else if (lv2 > rv1) {
                l = m + 1;
            }
        }

        return 0.0;
    }
}
