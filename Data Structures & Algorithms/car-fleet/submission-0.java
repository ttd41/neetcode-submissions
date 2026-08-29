class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int size = position.length;

        double[][] time = new double[size][2];

        for (int i = 0; i < size; i++) {
            int p = position[i];
            int sp = speed[i];
            time[i][0] = (double)(target - p) / sp;
            time[i][1] = p;
        }

        Arrays.sort(time, (a, b) -> Double.compare(b[1], a[1]));

        double currentTime = 0;
        int res = 0;

        for (double[] t: time) {
            if (t[0] > currentTime) {
                res++;
                currentTime = t[0];
            }
        }

        return res;
    }
}
