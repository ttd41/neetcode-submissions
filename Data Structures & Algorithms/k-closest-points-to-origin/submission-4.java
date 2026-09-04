class Solution {


    public int[][] kClosest(int[][] points, int k) {
        
        int s = 0;
        int e = points.length - 1;

        while (s < e) {
            int p = partition(points, s, e);
            if (p > k) {
                e = p - 1;
            } else if (p < k) {
                s = p + 1;
            } else {
                break;
            }
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;


    }


    public int partition(int[][] points, int s, int e) {
        if (s == e) {
            return s;
        }

        int pivot = d(points[s]);
        int i = s;
        for (int j = s + 1; j <= e; j++) {
            if (d(points[j]) <= pivot) {
                i++;
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
            }
        }
        int[] temp = points[i];
        points[i] = points[s];
        points[s] = temp;

        return i;
    }

    public int d(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }



}
