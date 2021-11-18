package trie;

public class TrieNode {

    private static int ALPHABET_SIZE = 26;

    public TrieNode[] childs;

    public boolean isWord;

    public TrieNode() {
        this.childs = new TrieNode[ALPHABET_SIZE];
    }

}
