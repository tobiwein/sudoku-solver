package dev.towe.control;

public class FieldDataProcessor {

    public static int getCellValue(final SudokuField field, final int row, final int col) {
        return field.getCell(row, col);
    }

    public static void setCellValue(final SudokuField field, final int row, final int col, final int value) {
        field.setCell(row, col, value);
    }

    public static boolean checkCellValidity(final SudokuField field, final int row, final int col) {
        final var rowValidity = checkRowValidity(field, row, col);
        final var columnValidity = checkColumnValidity(field, col, row);
        final var segmentValidity = checkSegmentValidity(field, row, col);
        return rowValidity && columnValidity && segmentValidity;
    }

    private static boolean checkRowValidity(final SudokuField field, final int row, final int index) {
        final var rowData = getFieldRowData(field, row);
        return checkDataValidity(rowData, index);
    }

    private static boolean checkColumnValidity(final SudokuField field, final int col, final int index) {
        final var colData = getFieldColumnData(field, col);
        return checkDataValidity(colData, index);
    }

    private static boolean checkSegmentValidity(final SudokuField field, final int row, final int col) {
        final var seg = getSegmentFromRowAndColumn(row, col);
        final var segData = getFieldSegmentData(field, seg);
        final var index = ((row % 3) * 3) + (col % 3);
        return checkDataValidity(segData, index);
    }

    private static boolean checkDataValidity(final int[] data, final int index) {
        if (data[index] == 0) {
            return true;
        }
        for (int i = 0; i < data.length; i++) {
            if (i != index && data[i] == data[index]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getFieldRowData(final SudokuField field, final int row) {
        int[] rowData = new int[9];
        for (int col = 0; col < 9; col++) {
            rowData[col] = field.getCell(row, col);
        }
        return rowData;
    }

    private static int[] getFieldColumnData(final SudokuField field, final int col) {
        int[] colData = new int[9];
        for (int row = 0; row < 9; row++) {
            colData[row] = field.getCell(row, col);
        }
        return colData;
    }

    private static int[] getFieldSegmentData(final SudokuField field, final int seg) {
        int[] segData = new int[9];
        int segDataIndex = 0;
        final int startRow = (seg / 3) * 3;
        final int startCol = (seg % 3) * 3;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                segData[segDataIndex++] = field.getCell(row, col);
            }
        }
        return segData;
    }

    private static int getSegmentFromRowAndColumn(final int row, final int col) {
        final int quadrantRow = row / 3;
        final int quadrantCol = col / 3;
        return quadrantRow * 3 + quadrantCol;
    }

}
