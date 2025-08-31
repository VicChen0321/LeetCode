class Solution {
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] blocks = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int n = board[r][c] - '0';
                    int blockIdx = getBlockIdx(r, c);
                    rows[r][n] = true;
                    cols[c][n] = true;
                    blocks[blockIdx][n] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        if (r == 9)
            return true;
        if (c == 9)
            return backtrack(board, r + 1, 0);
        if (board[r][c] != '.')
            return backtrack(board, r, c + 1);

        int blockIdx = getBlockIdx(r, c);
        for (int n = 1; n < 10; n++) {
            if (!rows[r][n] && !cols[c][n] && !blocks[blockIdx][n]) {
                rows[r][n] = cols[c][n] = blocks[blockIdx][n] = true;
                board[r][c] = (char) ('0' + n);

                if (backtrack(board, r, c + 1))
                    return true;

                board[r][c] = '.';
                rows[r][n] = cols[c][n] = blocks[blockIdx][n] = false;
            }
        }
        return false;
    }

    private int getBlockIdx(int r, int c) {
        return (r / 3) * 3 + c / 3;
    }
}