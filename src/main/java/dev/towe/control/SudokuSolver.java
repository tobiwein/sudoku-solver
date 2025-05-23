package dev.towe.control;

public class SudokuSolver {
    
    /**
     * Attempts to solve a given Sudoku puzzle using a backtracking algorithm.
     *
     * This method iterates over each cell in the Sudoku grid. If a cell is empty (value is 0),
     * it tries to fill it with a valid number (1-9) that adheres to Sudoku rules. If a valid number
     * is found, it recursively attempts to solve the rest of the puzzle. If no valid number is found,
     * it backtracks by resetting the cell value to 0 and tries the next possible number.
     *
     * @param field The Sudoku puzzle to be solved, represented as a SudokuField object.
     * @return true if the Sudoku puzzle is solved successfully, false otherwise.
     */
    public static boolean solve(final SudokuField field) {

        for (int currentRow = 0; currentRow < 9; currentRow++) {

            for (int currentCol = 0; currentCol < 9; currentCol++) {

                final var cellData = FieldDataProcessor.getCellValue(field, currentRow, currentCol);
                if (cellData == 0) {

                    // Get the next number to try for the current cell, starting from 1
                    int nextNumberToTry = getNextNumberToTry(field, currentRow, currentCol, 1);

                    boolean numberIsValid = false;
                    while (!numberIsValid) {

                        // If no valid number is found, backtrack
                        if (nextNumberToTry == -1) {
                            return false;
                        } else {

                            // Set the current cell to the next number to try
                            FieldDataProcessor.setCellValue(field, currentRow, currentCol, nextNumberToTry);

                            // Recursively attempt to solve the rest of the puzzle
                            if (!solve(field)) {

                                // If the recursive solve fails, reset the cell value to 0
                                FieldDataProcessor.setCellValue(field, currentRow, currentCol, 0);
                                // Get the next number to try, incrementing the last tried number
                                nextNumberToTry = getNextNumberToTry(field, currentRow, currentCol, nextNumberToTry + 1);

                            } else {

                                // If the recursive solve succeeds, mark the number as valid
                                numberIsValid = true;

                            }

                        }

                    }

                }

            }

        }

        // Return true if the entire puzzle is solved successfully
        return true;

    }

    private static int getNextNumberToTry(final SudokuField field, final int row, final int col, final int numberToTry) {

        for (int nextNumber = numberToTry; nextNumber <= 9; nextNumber++) {

            FieldDataProcessor.setCellValue(field, row, col, nextNumber);
            final var cellIsValid = FieldDataProcessor.checkCellValidity(field, row, col);
            FieldDataProcessor.setCellValue(field, row, col, 0); // Reset cell

            if (cellIsValid) {
                return nextNumber;
            }

        }

        return -1;

    }

}
