package trie;

/**
 * Created by rodsou on 12/13/16.
 */
public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void put(String word) {
    if (word == null || word.isEmpty()) {
      return;
    }

    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';

      if (p.children[index] == null) {
        TrieNode temp = new TrieNode();
        p.children[index] = temp;
        p = temp;
      } else {
        p = p.children[index];
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
    }
    return true;
  }

  public boolean startsWith(String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return false;
    }
    TrieNode p = searchNode(prefix);
    if (p == null) {
      return false;
    }
    return true;
  }

  private TrieNode searchNode(String word) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      int index = c - 'a';
      if (p.children[index] != null) {
        p = p.children[index];
      } else {
        return null;
      }
    }
    if (p == root) {
      return null;
    }
    return p;
  }
}
