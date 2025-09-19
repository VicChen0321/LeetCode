class Spreadsheet {
    int[][] mem;

    public Spreadsheet(int rows) {
        mem = new int[26][rows];
    }

    public void setCell(String cell, int value) {
        int colIdx = cell.charAt(0) - 'A';
        int rowIdx = Integer.valueOf(cell.substring(1)) - 1;
        mem[colIdx][rowIdx] = value;
    }

    public void resetCell(String cell) {
        int colIdx = cell.charAt(0) - 'A';
        int rowIdx = Integer.valueOf(cell.substring(1)) - 1;
        mem[colIdx][rowIdx] = 0;
    }

    public int getValue(String formula) {
        String x = formula.substring(1, formula.indexOf('+'));
        String y = formula.substring(formula.indexOf('+') + 1);
        return getCellOrValue(x) + getCellOrValue(y);
    }

    private int getCellOrValue(String cell) {
        if (cell.charAt(0) >= 'A' && cell.charAt(0) <= 'Z') {
            int colIdx = cell.charAt(0) - 'A';
            int rowIdx = Integer.valueOf(cell.substring(1)) - 1;
            return mem[colIdx][rowIdx];
        }
        return Integer.valueOf(cell);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */