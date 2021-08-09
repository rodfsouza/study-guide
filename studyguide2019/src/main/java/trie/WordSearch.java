package trie;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int row = 0; row < board.length; ++row) {

            for (int col = 0; col < board[0].length; ++col) {

                if (isSameLetter(board[row][col], 0, word) && traverseBoard(board, row, col, visited, 0, word) && !visited[row][col]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean traverseBoard(char[][] board, int row, int col, boolean[][] visited, int index, String word) {

        if (isSameWordSize(index, word)) {
            return true;
        }

        if (!isValidToMove(board, row, col) ||
                visited[row][col] ||
                !isSameLetter(board[row][col], index, word)) {

            return false;
        }

        visited[row][col] = true;

        boolean found = traverseBoard(board, row + 1, col, visited, index + 1, word) ||
                traverseBoard(board, row - 1, col, visited, index + 1, word) ||
                traverseBoard(board, row, col + 1, visited, index + 1, word) ||
                traverseBoard(board, row, col - 1, visited, index + 1, word);

        visited[row][col] = false;
        return found;
    }

    private boolean isSameLetter(char c, int index, String word) {
        return c == word.charAt(index);
    }

    private boolean isSameWordSize(int index, String word) {
        return index == word.length();
    }

    private boolean isValidToMove(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        return true;
    }

}
