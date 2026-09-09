class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            // 始终扩展较小的一端，减少搜索空间
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : startSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[i] = c;
                        String nextWord = String.valueOf(chars);

                        // 两端相遇
                        if (endSet.contains(nextWord)) {
                            return step + 1;
                        }

                        if (wordSet.contains(nextWord)) {
                            nextSet.add(nextWord);
                            wordSet.remove(nextWord); // 相当于标记已访问
                        }
                    }
                    chars[i] = originalChar;
                }
            }

            startSet = nextSet;
            step++;
        }

        return 0;
    }
}