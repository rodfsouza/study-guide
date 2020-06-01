package trie;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        word.toLowerCase();
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {

            int index = getIndex(word.charAt(i));

            if (p.childs[index] == null) {
                TrieNode temp = new TrieNode();
                p.childs[index] = temp;
                p = temp;
            } else {
                p = p.childs[index];
            }
        }
        p.isWord = true;
    }

    public boolean contains(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        word.toLowerCase();
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = getIndex(word.charAt(i));
            if (p.childs[index] == null) {
                return false;
            } else {
                p = p.childs[index];
            }
        }
        return true;
    }

    private int getIndex(char c) {
        return c - 'a';
    }
}
