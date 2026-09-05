class WordDictionary {

    Trie root;

    class Trie {
        Trie[] cs;
        boolean isWord;
        Trie() {
            this.cs = new Trie[26];
            this.isWord = false;
        }
    }

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for (char c: word.toCharArray()) {
            if (curr.cs[c - 'a'] == null) {
                curr.cs[c - 'a'] = new Trie();
            }
            curr = curr.cs[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);

    }

    public boolean search(String word, Trie trie) {
        int len = word.length();
        Trie curr = trie;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean res;
                for (Trie t: curr.cs) {
                    if (t != null) {
                        res = search(word.substring(i + 1), t);
                        if (res) {
                            return true;
                        }
                    }
                }
                return false;
            } else if (curr.cs[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.cs[c - 'a'];
            }
        }
        return curr != null && curr.isWord;
    }
}
