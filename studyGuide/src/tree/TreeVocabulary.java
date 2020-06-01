package tree;

import trie.Vocabulary;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rodsou on 11/7/16.
 */
public class TreeVocabulary extends TreeSet<String> implements Vocabulary {

  public TreeVocabulary() {
    super();
  }

  public TreeVocabulary(Collection<String> c) {
    super(c);
  }

  @Override
  public boolean add(String word) {
    return super.add(word);
  }

  @Override
  public boolean isPrefix(String prefix) {
    String nextWord = ceiling(prefix);
    if (nextWord == null) {
      return false;
    }

    if (nextWord.equals(prefix)) {
      Set<String> tail = tailSet(nextWord, false);
      if (tail.isEmpty()) {
        return false;
      }
      nextWord = tail.iterator().next();
    }
    return nextWord.startsWith(prefix);
  }

  @Override
  public boolean contains(String word) {
    return super.contains(word);
  }

  public String getName() {
    return getClass().getName();
  }
}
