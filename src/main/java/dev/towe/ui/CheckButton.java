package dev.towe.ui;

import dev.towe.control.FieldDataProcessor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CheckButton extends Button {

    public CheckButton(final GameGrid gameGrid, final Button solveButton) {
        super("Check");
        this.setOnAction((final ActionEvent event) -> {

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    final var cell = gameGrid.getCell(row, col);
                    final var cellText = cell.getText();
                    final var cellIsEmpty = cellText.isEmpty();

                    if (!cellIsEmpty) {
                        final var cellValue = Integer.parseInt(cellText);
                        final var field = gameGrid.getField();
                        FieldDataProcessor.setCellValue(field, row, col, cellValue);
                    }

                }
            }

            boolean everyCellIsValid = true;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    final var field = gameGrid.getField();
                    final var cellIsValid = FieldDataProcessor.checkCellValidity(field, row, col);
                    final var cell = gameGrid.getCell(row, col);

                    if (!cellIsValid) {
                        cell.setStyle("-fx-control-inner-background: AA0000");
                        everyCellIsValid = false;
                    }

                }
            }

            if (everyCellIsValid) {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {

                        final var cell = gameGrid.getCell(row, col);
                        cell.setEditable(false);

                        final var cellIsEmpty = cell.getText().isEmpty();
                        if (!cellIsEmpty) {
                            cell.setStyle("-fx-control-inner-background: AAAAAA");
                        }

                    }
                }

                solveButton.setDisable(false);
                this.setDisable(true);

            }
            
        });
    }
    
}
