//day 40 of daily leetcode

class Spreadsheet {
    private int[][] grid; // rows × 26

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // all initialized to 0
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        int row = pos[0], col = pos[1];
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        int row = pos[0], col = pos[1];
        grid[row][col] = 0;
    }

    public int getValue(String formula) {
        // Formula format: =X+Y
        String expr = formula.substring(1); // remove "="
        String[] parts = expr.split("\\+");
        int left = getOperandValue(parts[0]);
        int right = getOperandValue(parts[1]);
        return left + right;
    }

    // Helper: get value from operand (cell ref or number)
    private int getOperandValue(String s) {
        if (Character.isLetter(s.charAt(0))) { // it's a cell
            int[] pos = parseCell(s);
            return grid[pos[0]][pos[1]];
        } else { // it's a number
            return Integer.parseInt(s);
        }
    }

    // Parse "A1" -> [rowIndex, colIndex]
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // 1-indexed
        return new int[]{row, col};
    }
}
