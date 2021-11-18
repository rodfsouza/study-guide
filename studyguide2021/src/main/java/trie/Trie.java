package trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        if (word == null || word.isEmpty() || word.isBlank()) {
            return;
        }

        word.toLowerCase();
        TrieNode pointer = root;

        for (int i = 0; i < word.length(); ++i) {

            int index = getIndex(word.charAt(i));
            if (pointer.childs[index] == null) {
                TrieNode node = new TrieNode();
                pointer.childs[index] = node;
                pointer = node;
            } else {
                pointer = pointer.childs[index];
            }
        }
        pointer.isWord = true;
    }

    public boolean contains(String word) {

        if (word == null || word.isEmpty() || word.isBlank()) {
            return false;
        }

        word.toLowerCase();
        TrieNode pointer = root;

        for (int i = 0; i < word.length(); ++i) {

            int index = getIndex(word.charAt(i));
            if (pointer.childs[index] == null) {
                return false;
            } else {
                pointer = pointer.childs[index];
            }
        }
        return true;
    }

    private int getIndex(char c) {
        return c - 'a';
    }
}
