package trie;

/**
 * Created by rodsou on 11/7/16.
 */
public interface Vocabulary {
  boolean add(String word);
  boolean isPrefix(String prefix);
  boolean contains(String word);
}
