package trie;

/**
 * Created by rodsou on 7/16/17.
 */
public class Trie2 {

    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        TrieNode p = root;
        String lowercase = word.toLowerCase();

        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            int charIndex = c - 'a';

            if (p.children[charIndex] == null) {
                TrieNode tmp = new TrieNode();
                p.children[charIndex] = tmp;
                p = tmp;
            } else {
                p = p.children[charIndex];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd) {
                return true;
            }
        }
        return false;
    }

    public boolean starsWith(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode searchNode(String s) {
        TrieNode n = root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (n.children[index] != null) {
                n = n.children[index];
            } else {
                return null;
            }
        }
        return n == root ? null : n;
    }

    public static void main(String... args) {
        Trie2 trie = new Trie2();
        trie.insert("Rodrigo");
        System.out.println(trie.search("ovo"));
        System.out.println(trie.starsWith("r"));
    }
}
