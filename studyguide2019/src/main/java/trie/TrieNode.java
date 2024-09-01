package trie;

public class ATrieNode {

    TrieNode childs[];
    int ALPHABET_SIZE = 26;
    boolean isWord;

    public TrieNode() {
        childs = new TrieNode[ALPHABET_SIZE];
    }
}
