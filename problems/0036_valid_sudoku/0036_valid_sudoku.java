class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boardSet = new HashSet[9];

        // initialize set
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boardSet[i] = new HashSet<>();
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;
                int boardIdx = (r / 3 * 3) + (c / 3);
                if (!rowSet[r].add(val))
                    return false;
                if (!colSet[c].add(val))
                    return false;
                if (!boardSet[boardIdx].add(val))
                    return false;
            }
        }
        return true;
    }
}