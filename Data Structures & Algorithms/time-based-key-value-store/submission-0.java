class TimeMap {

    class Node {
        String v;
        int ts;

        public Node(String v, int ts) {
            this.v = v;
            this.ts = ts;
        }
    }

    HashMap<String, List<Node>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> list = hm.getOrDefault(key, new ArrayList<>());
    
        int p = bs(list, timestamp);
        list.add(p, new Node(value, timestamp));

        hm.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) {
            return "";
        }

        List<Node> list = hm.get(key);
        int p = bs(list, timestamp);
        if (p == 0) {
            return "";
        }
        return list.get(p - 1).v;
    }

    // return the min index that's value larger than ts
    public int bs(List<Node> list, int ts) {
        int len = list.size();
        int l = 0, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m).ts > ts) {
                r = m; 
            } else {
                l = m + 1;
            }
        }

        return l;
    }

}
