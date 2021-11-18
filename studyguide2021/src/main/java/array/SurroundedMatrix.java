package array;

public class SurroundedMatrix {

    private final int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        //traverse first and last column
        colTraversal(board, visited, 0);

        //traverse first and last row
        rowTraversal(board, visited,0);

        for (int row = 1; row < board.length; ++row) {
            for (int col = 1; col < board[0].length; ++col) {

                if (board[row][col] == 'O' && !visited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    public void colTraversal(char[][] board, boolean[][] visited,int row) {

        for (int col = 0; col < board[0].length; ++col) {

            if (board[row][col] == 'O' && !visited[row][col]) {
                dirTraversal(board, visited, row, col);
            }

            if (board[board.length - 1][col] == 'O' && !visited[board.length - 1][col]) {
                dirTraversal(board, visited, board.length - 1, col);
            }
        }
    }

    public void rowTraversal(char[][] board, boolean visited[][], int col) {

        for (int row = 0; row < board.length; ++row) {

            if (board[row][col] == 'O' && !visited[row][col]) {
                dirTraversal(board, visited, row, col);
            }

            if (board[row][board[0].length - 1] == 'O' && !visited[row][board[0].length - 1]) {
                dirTraversal(board, visited, row, board[0].length - 1);
            }
        }
    }

    public void dirTraversal(char[][] board, boolean[][] visited,int row, int col) {

        visited[row][col] = true;

        for (int[] dir : DIRS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (isValid(board, nextRow, nextCol) && board[nextRow][nextCol] == 'O' && !visited[nextRow][nextCol]) {
                dirTraversal(board, visited, nextRow, nextCol);
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
