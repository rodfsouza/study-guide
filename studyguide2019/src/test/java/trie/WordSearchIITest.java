package trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordSearchIITest {

    @Test
    public void  testFoundValidWords() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        WordSearchII search = new WordSearchII();
        List<String> result = search.findWords(board, words);
        Assertions.assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void  testFoundValidWordsII() {
        char[][] board = {{'a'}};
        String[] words = {"a"};

        WordSearchII search = new WordSearchII();
        List<String> result = search.findWords(board, words);
        Assertions.assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void  testFoundValidWordsSingleChar() {
        char[][] board = {{'a'}, {'a'}};
        String[] words = {"aaa"};

        WordSearchII search = new WordSearchII();
        List<String> result = search.findWords(board, words);
        Assertions.assertTrue(result != null && result.isEmpty());
    }
}
