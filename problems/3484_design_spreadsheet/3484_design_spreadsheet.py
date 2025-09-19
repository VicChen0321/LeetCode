class Spreadsheet:

    def __init__(self, rows: int):
        self._map = {}

    def setCell(self, cell: str, value: int) -> None:
        self._map[cell] = value
        
    def resetCell(self, cell: str) -> None:
        self._map[cell] = 0
        
    def getValue(self, formula: str) -> int:
        exp = formula[1:]
        a, b = exp.split("+")
        return self.valueOf(a) + self.valueOf(b)
    
    def valueOf(self, token: str) -> int:
        if token[0].isdigit():
            return int(token)
        return self._map.get(token, 0)
        


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)