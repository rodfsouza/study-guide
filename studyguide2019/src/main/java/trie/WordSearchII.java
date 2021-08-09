package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        root = new TrieNode();

        for(String word : words) {
            insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> results = new HashSet<>();
        TrieNode node = root;

        for (int row = 0; row < board.length; ++row) {

            for (int col = 0; col < board[0].length; ++col) {

                if (!visited[row][col]) {
                    traverse(board, row, col, visited, node, results);

                    char c = board[row][col];
                    TrieNode n = node.getChild(c);
                    if (n != null && n.isWord && !results.contains(n.word)) {
                        results.add(n.word);
                    }
                }
            }
        }

        return new ArrayList<>(results);
    }

    private int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void traverse(char[][] board, int row, int col, boolean[][]visited, TrieNode next, Set<String> foundWords) {

        if (next == null) {
            return;
        }

        if (next.isWord && !foundWords.contains(next.word)) {
            foundWords.add(next.word);
        }

        for(int[] dir : DIRECTIONS) {
            int y = row + dir[0];
            int x = col + dir[1];

            if (!isValidMove(board, y, x) || visited[y][x]) {
                continue;
            }

            char curr = board[y][x];

            visited[y][x] = true;

            traverse(board, y, x, visited, next.getChild(curr), foundWords);

            visited[y][x] = false;
        }
    }


    private boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        return true;
    }

    private void insert(String word) {

        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode p = root;

        for(int i = 0; i < word.length(); ++i) {

            char c = word.charAt(i);
            int index = getIndex(c);

            if (p.childs[index] == null) {

                TrieNode temp = new TrieNode();
                p.childs[index] = temp;
                p = p.childs[index];

            } else {

                p = p.childs[index];
            }
        }

        p.isWord = true;
        p.word = word;
    }

    private static int getIndex(char c) {
        return c - 'a';
    }

    private static class TrieNode {

        TrieNode childs[];
        boolean isWord;
        String word;

        public TrieNode() {
            childs = new TrieNode[26];
        }

        public TrieNode getChild(char c) {
            return childs[getIndex(c)];
        }
    }
}
