class PrefixTree {

    class Trie {
        Trie[] cas;
        boolean isWord;
        public Trie() {
            cas = new Trie[26];
            isWord = false;
        }
    }

    Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie node = root;
        for (char c: word.toCharArray()) {
            if (node.cas[c - 'a'] == null) {
                 node.cas[c - 'a'] = new Trie();
            }
            node =  node.cas[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Trie node = root;
        for (char c: word.toCharArray()) {
            node =  node.cas[c - 'a'];
            if (node == null) {
                break;
            }
        }
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie node = root;
        for (char c: prefix.toCharArray()) {
            node =  node.cas[c - 'a'];
            if (node == null) {
                break;
            }
        }
        return node != null;

    }
}
