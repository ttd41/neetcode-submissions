class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Map<String, List<String>> hm = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(beginWord);
        for (String w1: wordSet) {
            for (String w2: wordSet) {
                if (isConnected(w1, w2)) {
                    hm.computeIfAbsent(w1, k -> new ArrayList<>()).add(w2);
                    hm.computeIfAbsent(w2, k -> new ArrayList<>()).add(w1);
                }
            }
        }


        Deque<String> startQ = new ArrayDeque<>();
        HashSet<String> startV = new HashSet<>();
        startV.add(beginWord);
        startQ.add(beginWord);
        Deque<String> endQ = new ArrayDeque<>();
        HashSet<String> endV = new HashSet<>();
        endV.add(endWord);
        endQ.add(endWord);  

        int step = 2;
        while (!startQ.isEmpty() || !endQ.isEmpty()) {
            Deque<String> q1 = startQ;
            Deque<String> q2 = endQ;
            HashSet<String> v1 = startV;
            HashSet<String> v2 = endV;
            if (q1.isEmpty() || (!q2.isEmpty() && q1.size() > q2.size())) {
                Deque<String> tempq = q1;
                q1 = q2;
                q2 = tempq;
                HashSet<String> tempv = v1;
                v1 = v2;
                v2 = tempv;
            } 
            int len = q1.size();
            for (int i = 0; i < len; i++) {
                String curr = q1.poll();
                for (String s: hm.getOrDefault(curr, List.of())) {
                    if (!v1.contains(s)) {
                        v1.add(s);
                        q1.add(s);
                    }
                }
            }
            boolean hasCommon = !Collections.disjoint(v1, v2);
            if (hasCommon) {
                return step;
            }
            step++;
        }

        return 0;
        
    }

    public boolean isConnected(String w1, String w2) {
        int len = w1.length();
        int notS = 0;
        for (int i = 0; i < len; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                notS++;
            }
            if (notS > 1) {
                return false;
            }
        }
        return notS == 1;
    }
}
