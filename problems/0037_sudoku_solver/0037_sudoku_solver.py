class Solution:
    def __init__(self):
        self.rows = [[False] * 10 for _ in range(9)]
        self.cols = [[False] * 10 for _ in range(9)]
        self.blocks = [[False] * 10 for _ in range(9)]

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for r in range(9):
            for c in range(9):
                if board[r][c] != '.':
                    n = int(board[r][c])
                    block_idx = self.getBlockIdx(r, c)
                    self.rows[r][n] = True
                    self.cols[c][n] = True
                    self.blocks[block_idx][n] = True
        self.backtrack(board, 0, 0)
    
    def backtrack(self, board: List[List[str]], r : int, c :int) -> bool:
        if r == 9:
            return True
        if c == 9:
            return self.backtrack(board, r + 1, 0)
        if board[r][c] != '.':
            return self.backtrack(board, r, c + 1)
        block_idx = self.getBlockIdx(r, c)
        for n in range(1, 10):
            if not self.rows[r][n] and not self.cols[c][n] and not self.blocks[block_idx][n]:
                self.rows[r][n] = self.cols[c][n] = self.blocks[block_idx][n] = True
                board[r][c] = str(n)
                if self.backtrack(board, r, c + 1):
                    return True
                
                ## Rollback
                board[r][c] = '.'
                self.rows[r][n] = self.cols[c][n] = self.blocks[block_idx][n] = False

        return False

    def getBlockIdx(self, r: int, c: int) -> int:
        return (r // 3) * 3 + (c // 3)