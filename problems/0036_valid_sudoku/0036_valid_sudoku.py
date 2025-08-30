class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boards = [set() for _ in range(9)]
        for r in range(9):
            for c in range(9):
                val = board[r][c]
                if val == '.':
                    continue
                board_idx = (r // 3) * 3 + (c // 3)
                if val in rows[r] or val in cols[c] or val in boards[board_idx]:
                    return False
                rows[r].add(val)
                cols[c].add(val)
                boards[board_idx].add(val)
        return True