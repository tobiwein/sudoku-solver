package dev.towe.ui;

import dev.towe.control.SudokuField;
import javafx.scene.layout.GridPane;

public class GameGrid extends GridPane {

    private final Cell[][] cells = new Cell[9][9];
    private SudokuField field = new SudokuField();

    private final int TEXT_FIELD_SIZE = 40;
    private final int SEPERATOR_THICKNESS = 2;
    private final int GRID_SIZE = (TEXT_FIELD_SIZE * 9) + (SEPERATOR_THICKNESS * 2);

    public GameGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                final var cell = new Cell(TEXT_FIELD_SIZE, TEXT_FIELD_SIZE);
                cells[row][col] = cell;

                final int gridCol = col + (col / 3);
                final int gridRow = row + (row / 3);
                this.add(cell, gridCol, gridRow);

            }
        }

        // Vertical seperators
        this.add(new Seperator(SEPERATOR_THICKNESS, GRID_SIZE), 3, 0, 1, 11);
        this.add(new Seperator(SEPERATOR_THICKNESS, GRID_SIZE), 7, 0, 1, 11);

        // Horizontal Seperators
        this.add(new Seperator(GRID_SIZE, SEPERATOR_THICKNESS), 0, 3, 11, 1);
        this.add(new Seperator(GRID_SIZE, SEPERATOR_THICKNESS), 0, 7, 11, 1);
    }

    public SudokuField getField() {
        return field;
    }

    public void newField() {
        this.field = new SudokuField();
    }

    public Cell getCell(final int index1, final int index2) {
        return cells[index1][index2];
    }
    
}
