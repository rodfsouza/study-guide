package trie;

/**
 * Created by rodsou on 12/13/16.
 */
public class TrieNode {
  private static final int ALPHABET_SIZE = 26;

  TrieNode children[];
  boolean isEnd;

  public TrieNode() {
    children = new TrieNode[ALPHABET_SIZE];
  }
}
