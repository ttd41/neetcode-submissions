class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] res = new boolean[3];
        for (int[] t: triplets) {
            checkCandidate(t, target, res);
            if (res[0] && res[1] && res[2]) {
                return true;
            }
        }

        return false;
    }

    public void checkCandidate(int[] triplet, int[] target, boolean[] res) {

        boolean[] equal = new boolean[3];
        for (int i = 0; i < 3; i++) {
            if (triplet[i] == target[i]) {
                equal[i] = true;
            } else if (triplet[i] > target[i]) {
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            res[i] |= equal[i];
        }
    }
}
