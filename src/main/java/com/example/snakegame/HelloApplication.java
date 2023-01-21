package com.example.snakegame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.fill(Color.hsb(136.0,0.5,0.79)));
        //grid.setGridLinesVisible(true);

        final Text action = new Text();
        grid.add(action, 0, 6);
        Label welcomeLabel = new Label("Hello there! This is my Snake game! ENJOY!");
        Label customizeLabel = new Label("Customize your Snake (if you want)");
        Label colorLabel = new Label("Choose color:");
        Label nameLabel = new Label("Enter snake name:");
        TextField nameField = new TextField();
        Button startButton = new Button("Start!");
        HBox hbStart = new HBox(10);
        hbStart.getChildren().add(startButton);
        startButton.setOnAction(e -> {
            action.setFill(Color.FIREBRICK);
            action.setText(nameField.getText());
        });
        ColorPicker colorPicker = new ColorPicker(Color.AQUA);
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        grid.add(welcomeLabel, 0, 0);
        grid.add(customizeLabel, 0, 1);
        grid.add(colorLabel, 0, 2);
        grid.add(colorPicker, 0, 2);
        grid.add(nameLabel, 0, 3);
        grid.add(nameField, 0, 4);
        grid.add(hbStart,0, 5);
        grid.add(startButton,0, 5);

        Scene scene = new Scene(grid, 600, 550);
        stage.setTitle("Snake The Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}