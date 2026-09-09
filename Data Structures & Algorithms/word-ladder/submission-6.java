class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        HashSet<String> startV = new HashSet<>();
        startV.add(beginWord);
        HashSet<String> endV = new HashSet<>();
        endV.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        int step = 2;
        HashSet<String> v1 = startV;
        HashSet<String> v2 = endV;
        while (!v1.isEmpty() && !v2.isEmpty()) {
            if (v1.size() > v2.size()) {
                HashSet<String> tempv = v1;
                v1 = v2;
                v2 = tempv;
            } 

            HashSet<String> nextSet = new HashSet<>();
            for (String w1: v1) {
                char[] ca1 = w1.toCharArray();
                for (int i = 0; i < ca1.length; i++) {
                    char oldc = ca1[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (oldc == c) {
                            continue;
                        }
                        ca1[i] = c;
                        String nextString = new String(ca1);
                        if (v2.contains(nextString)) {
                            return step;
                        }

                        if (wordSet.contains(nextString)) {
                            nextSet.add(nextString);
                            wordSet.remove(nextString);
                        }
                    }
                    ca1[i] = oldc;
                }
            }
            v1 = nextSet;
            step++;
            
        }

        return 0;
        
    }

}
