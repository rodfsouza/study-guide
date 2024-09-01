package array.matrix;

public class SurroundRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1) {
                    if (board[row][col] == 'O') {
                        dfs(board, row, col);
                    }
                }
            }
        }

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (!isValid(board, row, col) || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'S';

        dfs(board, row, col + 1);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row - 1, col);
    }

    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }
}
