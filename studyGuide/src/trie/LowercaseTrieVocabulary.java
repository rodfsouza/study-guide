package trie;

import java.util.Collection;

/**
 * Created by rodsou on 11/22/16.
 */
public class LowercaseTrieVocabulary implements Vocabulary {
  private boolean isWord = false;

  private LowercaseTrieVocabulary[] children = new LowercaseTrieVocabulary[Alphabet.LOWERCASE.size()];

  private int numChildren = 0;

  public LowercaseTrieVocabulary() {}

  public LowercaseTrieVocabulary(Collection<String> words) {
    for (String word : words) {
      add(word);
    }
  }

  @Override
  public boolean add(String word) {
    char first = word.charAt(0);
    int index = Alphabet.LOWERCASE.getIndex(first);
    if (index < 0) {
      System.out.println("uf");
    }

    LowercaseTrieVocabulary child = children[index];
    if (child == null) {
      child = new LowercaseTrieVocabulary();
      children[index] = child;
      numChildren++;
    }

    if (word.length() == 1) {
      if (child.isWord) {
        return false;
      }
      child.isWord = true;
      return true;
    } else {
      return child.add(word.substring(1));
    }
  }

  @Override
  public boolean isPrefix(String prefix) {
    LowercaseTrieVocabulary n = getNode(prefix);
    return n != null && n.numChildren > 0;
  }

  @Override
  public boolean contains(String word) {
    LowercaseTrieVocabulary n = getNode(word);
    return n != null && n.isWord;
  }

  public LowercaseTrieVocabulary getNode(String s) {
    LowercaseTrieVocabulary node = this;
    for (int i = 0; i < s.length(); i++) {
      int index = Alphabet.LOWERCASE.getIndex(s.charAt(i));
      LowercaseTrieVocabulary child = node.children[index];
      if (child == null) {
        // There is no such word
        return null;
      }
      node = child;
    }
    return node;
  }


  public boolean contains(byte[] indices, int offset, int len) {
    LowercaseTrieVocabulary n = getNode(indices, offset, len);
    return n != null && n.isWord;
  }

  public boolean contains(byte[] indices, int offset) {
    LowercaseTrieVocabulary n = getNode(indices, offset, indices.length-offset);
    return n != null && n.isWord;
  }


  public boolean isPrefix(byte[] indices, int offset, int len) {
    LowercaseTrieVocabulary n = getNode(indices, offset, len);
    return n != null && n.numChildren > 0;
  }

  public boolean isPrefix(byte[] indices, int offset) {
    LowercaseTrieVocabulary n = getNode(indices, offset, indices.length-offset);
    return n != null && n.numChildren > 0;
  }

  public LowercaseTrieVocabulary getNode(byte[] indices, int offset, int len) {
    LowercaseTrieVocabulary node = this;
    for (int i = 0; i < len; i++) {
      int index = indices[offset+i];
      LowercaseTrieVocabulary child = node.children[index];
      if (child == null) {
        // There is no such word
        return null;
      }
      node=child;
    }
    return node;
  }

  public String getName() {
    return getClass().getName();
  }

  public boolean isWord() {
    return isWord;
  }

  public boolean hasChildren() {
    return numChildren > 0;
  }
}
