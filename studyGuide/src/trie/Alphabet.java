package trie;

/**
 * Created by rodsou on 11/22/16.
 */
public abstract class Alphabet {

  public final String alphabet;

  public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmonpqrstuvwxyz") {
    private final int charOffSet = Character.getNumericValue('a');

    public byte getIndex(char c) {
      return (byte) (Character.getNumericValue(c) - charOffSet);
    }
  };

  public Alphabet(String alphabet) {
    this.alphabet = alphabet;
  }

  public byte[] getIndex(String word) {
    byte[] r = new byte[word.length()];
    for (int i = 0; i < r.length; i++) {
      r[i] = getIndex(word.charAt(i));
    }
    return r;
  }

  public byte getIndex(char c) {
    return (byte) alphabet.indexOf(c);
  }

  public int size() {
    return alphabet.length();
  }
}
