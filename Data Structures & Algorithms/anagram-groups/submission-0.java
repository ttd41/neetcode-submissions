class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s: strs) {
            int[] ana = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int id = s.charAt(i) - 'a';
                ana[id] ++;
            }
            String key = toKey(ana);
            List<String> l = m.getOrDefault(key, new ArrayList<>());
            l.add(s);
            m.put(key, l);
        }

        for (List<String> l: m.values()) {
            res.add(l);
        }

        return res;
    }

    public String toKey(int[] ana) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ana.length; i++) {
            if (ana[i] != 0) {
                sb.append('a' + i);
                sb.append(ana[i]);
            }
        }
        return sb.toString();
    }
}
