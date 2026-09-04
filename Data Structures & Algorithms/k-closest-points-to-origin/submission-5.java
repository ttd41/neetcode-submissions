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
        int i = s + 1, j = e;
        while (i <= j) {
            while (i <= j && d(points[i]) <= pivot) i++;
            while (i <= j && d(points[j]) >= pivot) j--;
            if (i < j) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
                j--;
            }
        }

        int[] temp = points[i - 1];
        points[i - 1] = points[s];
        points[s] = temp;
        
        return i - 1;
    }

    public int d(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }



}
