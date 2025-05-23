package dev.towe.ui;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Cell extends TextField {

    public Cell(final int textFieldWidth, final int textFieldHeight) {
        this.setPrefSize(textFieldWidth, textFieldHeight);
        this.setAlignment(Pos.CENTER);
        this.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        this.textProperty().addListener((final ObservableValue<? extends String> observableValue, final String oldValue, final String newValue) -> {
            if (newValue.isEmpty()) {
                // Allow the field to be deleted
                return;
            }
            if (!newValue.matches("[1-9]")) {
                // Only allow values between 1 and 9
                this.setText(oldValue);
            }
        });
    }
    
}
