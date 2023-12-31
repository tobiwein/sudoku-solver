package dev.tobiasweinlich.sudoku.field;

public class FieldFactory {

    public static Field getInstance() {
        return new Field();
    }

    public static Field getInstance(final int[][] rawField) {
        final var rawFieldIsLegal = rawFieldIsLegal(rawField);

        if (!rawFieldIsLegal) {
            throw new IllegalArgumentException("Illegal raw field");
        }

        return new Field(rawField);
    }

    public static int[][] getRawField(final Field field) {
        return field.getRawField();
    }

    private static boolean rawFieldIsLegal(final int[][] rawField) {
        final var numberOfRows = rawField.length;

        if (numberOfRows == 0) {
            return false;
        }

        final var numberOfCols = rawField[0].length;    

        return (numberOfRows == 9 && numberOfCols == 9);
    }

}