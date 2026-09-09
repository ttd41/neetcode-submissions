class Solution {

    class DSU {
        
        int[] p;
        int[] size;

        public DSU (int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int n) {
            if (p[n] != n) {
                p[n] = find(p[n]);
            }
            return p[n];
        }

        public boolean connect(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 == p2) return false;
            if (size[p1] > size[p2]) {
                p[p2] = p1;
                size[p1] += size[p2];
            } else {
                p[p1] = p2;
                size[p2] += size[p1];
            }
            return true;
        }
    }
    

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int num = n;
        for (int[] e: edges) {
            if (dsu.connect(e[0], e[1])) {
                num--;
            }
        }

        return num;
    }
}
