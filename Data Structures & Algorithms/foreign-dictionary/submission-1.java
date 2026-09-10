class Solution {
    public String foreignDictionary(String[] words) {
        int[] inD = new int[26];
        boolean[] inW = new boolean[26];
        int len = words.length;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int totalC = 0;
        for (String s: words) {
            for (char c: s.toCharArray()) {
                if (!inW[c - 'a']) {
                    inW[c - 'a'] = true;
                    totalC++;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(!addDep(words[i], words[j], edges, inD)) {
                    return "";
                }
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (inW[i] && inD[i] == 0) {
                dq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int from = dq.poll();
            sb.append((char)(from + 'a'));
            for (Integer to: edges.getOrDefault(from, new ArrayList<>())) {
                inD[to]--;
                if (inD[to] == 0) {
                    dq.add(to);
                }
            }
            edges.remove(from);
        }

        return sb.length() == totalC ? sb.toString() : "";
    }

    public boolean addDep(String w1, String w2, Map<Integer, List<Integer>> edges, int[] inD) {
        int i = 0;
        while (i < w1.length() && i < w2.length()) {
            if (w1.charAt(i) != w2.charAt(i)) {
                int from = w1.charAt(i) - 'a';
                int to = w2.charAt(i) - 'a';
                edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
                inD[to]++;
                return true;
            };
            i++;
        }

        if (w1.length() > w2.length() && i >= w2.length()) {
            return false;
        }

        return true;
    }
}
