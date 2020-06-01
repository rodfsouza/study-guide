package trie;

public class TrieNode {

    TrieNode childs[];
    int ALPHABET_SIZE = 26;
    boolean isWord;

    public TrieNode() {
        childs = new TrieNode[ALPHABET_SIZE];
    }
}
