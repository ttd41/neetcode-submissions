class Solution {

    class Trie {
        boolean isWord;
        Trie[] ts;

        public Trie() {
            this.isWord = false;
            this.ts = new Trie[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        Trie root = new Trie();
        for (String w: wordDict) {
            Trie curr = root;
            for (int i = w.length() - 1; i >=0; i--) {
                char c = w.charAt(i);
                if (curr.ts[c - 'a'] == null) {
                    curr.ts[c - 'a'] = new Trie();
                }
                curr = curr.ts[c - 'a'];
            }
            curr.isWord = true;
        }

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        char[] ca = s.toCharArray();
        for (int i = 0; i < len; i++) {
            Trie curr = root;
            int index = i;
            while (index >= 0 && !(curr.isWord && dp[index + 1]) && curr.ts[ca[index] - 'a'] != null) {
                curr = curr.ts[ca[index] - 'a'];
                index--;
            }
            if (dp[index + 1] && curr.isWord) {
                dp[i + 1] = true;
            }
        }

        return dp[len];
    }
}
