package dev.towe.ui;

import dev.towe.control.SudokuSolver;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SolveButton extends Button {

    public SolveButton(final GameGrid gameGrid) {
        super("Solve");
        
        this.setDisable(true);
        this.setOnAction((final ActionEvent event) -> {

            final var field = gameGrid.getField();
            SudokuSolver.solve(field);

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    final var cell = gameGrid.getCell(row, col);
                    final var fieldCell = field.getCell(row, col);
                    cell.setText(String.valueOf(fieldCell));

                }
            }

            this.setDisable(true);
            
        });

    }
    
}
