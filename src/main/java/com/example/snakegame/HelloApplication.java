package com.example.snakegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    public static String NAME = "";
    public static String DIFFICULT = "Easy";
    public static Color COLOR = Color.GREEN;

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text action = new Text();
        grid.add(action, 0, 10 );
        action.setId("start");
        Label welcomeLabel = new Label("Hello there! This is my Snake game! ENJOY!");
        Label customizeLabel = new Label("Customize your Snake (if you want)");
        Label colorLabel = new Label("Choose color:");
        Label nameLabel = new Label("Enter snake name:");
        Label chooseDifficult = new Label("Choose Difficult:");

        ColorPicker colorPicker = new ColorPicker(Color.GREEN);
        TextField nameField = new TextField();
        nameField.setMaxWidth(200.0);
        Button startButton = new Button("Start!");
        ToggleGroup difficultGroup = new ToggleGroup();
        RadioButton easyButton = new RadioButton("Easy");
        RadioButton normalButton = new RadioButton("Normal");
        RadioButton hardButton = new RadioButton("Hard");
        easyButton.setToggleGroup(difficultGroup);
        easyButton.setSelected(true);
        normalButton.setToggleGroup(difficultGroup);
        hardButton.setToggleGroup(difficultGroup);
        HBox hbStart = new HBox(10);
        hbStart.getChildren().add(startButton);
        startButton.setOnAction(e -> {
            NAME = nameField.getText();
            DIFFICULT = ((RadioButton) difficultGroup.getSelectedToggle()).getText();
            COLOR = colorPicker.getValue();
            //action.setText("Your name is: " + NAME + "\nYour difficult: " + DIFFICULT + nameField.getWidth() + COLOR);
        });
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        customizeLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        grid.add(welcomeLabel, 0, 0);
        grid.add(customizeLabel, 0, 1);
        grid.add(colorLabel, 0, 2);
        grid.add(colorPicker, 0, 2);
        grid.add(nameLabel, 0, 3);
        grid.add(nameField, 0, 4);
        grid.add(chooseDifficult, 0, 5);
        grid.add(easyButton, 0, 6);
        grid.add(normalButton, 0, 7);
        grid.add(hardButton, 0, 8);
        grid.add(hbStart,0, 9);
        grid.add(startButton,0, 9);

        Scene scene = new Scene(grid, 600, 550);
        stage.setTitle("Snake The Game");
        scene.getStylesheets().add(getClass().getResource("/styles/Menu.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResource("/img/icon.jpg").toExternalForm()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}