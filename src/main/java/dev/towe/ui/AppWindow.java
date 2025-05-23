package dev.towe.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AppWindow extends Application {

    @Override
    public void start(final Stage primaryStage) {

        final var game = new GameGrid();
        
        final var solveButton = new SolveButton(game);
        final var checkButton = new CheckButton(game, solveButton);
        final var clearButton = new ClearButton(game, solveButton, checkButton);

        final var buttons = new TilePane();
        buttons.getChildren().add(clearButton);
        buttons.getChildren().add(checkButton);
        buttons.getChildren().add(solveButton);

        final var app = new GridPane();
        app.add(game, 0, 0);
        app.add(buttons, 0, 1);

        final var scene = new Scene(app, 364, 400);
        
        primaryStage.setTitle("Sudoku Solver");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
