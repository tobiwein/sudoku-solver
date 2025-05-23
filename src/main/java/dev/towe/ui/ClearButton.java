package dev.towe.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ClearButton extends Button {

    public ClearButton(final GameGrid gameGrid, final Button solveButton, final Button checkButton) {
        super("Clear");
        this.setOnAction((final ActionEvent event) -> {

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    final var cell = gameGrid.getCell(row, col);
                    cell.setStyle("-fx-control-inner-background: FFFFFF");
                    cell.setEditable(true);
                    cell.setText("");

                    gameGrid.newField();

                }
            }

            solveButton.setDisable(true);
            checkButton.setDisable(false);
            
        });
    }
    
}
