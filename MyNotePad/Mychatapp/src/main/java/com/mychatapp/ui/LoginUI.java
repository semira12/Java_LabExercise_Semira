package com.mychatapp.ui;

import com.mychatapp.database.DatabaseManager;
import com.mychatapp.ui.ChatUI;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI extends Application {

    private DatabaseManager databaseManager =
            new DatabaseManager();

    @Override
    public void start(Stage stage) {

        Label title =
                new Label("Chat Login");

        TextField usernameField =
                new TextField();

        usernameField.setPromptText("Username");

        PasswordField passwordField =
                new PasswordField();

        passwordField.setPromptText("Password");

        Button loginButton =
                new Button("Login");
        loginButton.setOnAction(event -> {

            String username =
                    usernameField.getText();

            String password =
                    passwordField.getText();

            boolean valid =
                    databaseManager.validateLogin(
                            username,
                            password
                    );

            if (valid) {

                ChatUI chatUI =
                        new ChatUI(username);

                try {

                    chatUI.start(new Stage());

                    stage.close();

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setContentText("Invalid login!");

                alert.show();
            }
        });

        Button registerButton =
                new Button("Register");
        registerButton.setOnAction(event -> {

            String username =
                    usernameField.getText();

            String password =
                    passwordField.getText();

            boolean registered =
                    databaseManager.registerUser(
                            username,
                            password
                    );

            Alert alert;

            if (registered) {

                alert =
                        new Alert(Alert.AlertType.INFORMATION);

                alert.setContentText("Registered!");

            } else {

                alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setContentText("Registration failed!");
            }

            alert.show();
        });

        VBox root =
                new VBox(
                        10,
                        title,
                        usernameField,
                        passwordField,
                        loginButton,
                        registerButton
                );

        root.setAlignment(Pos.TOP_CENTER);

        Scene scene =
                new Scene(root, 300, 250);

        stage.setScene(scene);

        stage.setTitle("Login");

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}