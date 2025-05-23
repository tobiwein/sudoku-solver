package dev.towe.control;

public class SudokuField {

    private int[][] sudokuField;

    public SudokuField() {
        sudokuField = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public int[][] getField() {
        return sudokuField;
    }

    public void setField(final int[][] newFieldData) {
        sudokuField = newFieldData;
    }

    public int getCell(final int row, final int column) {
        return sudokuField[row][column];
    }

    public void setCell(final int row, final int column, final int cellData) {
        sudokuField[row][column] = cellData;
    }
    
}
