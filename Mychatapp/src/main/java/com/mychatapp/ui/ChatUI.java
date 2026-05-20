package com.mychatapp.ui;

import com.mychatapp.client.Client;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatUI {
    private String username;

    private Client client =
            new Client();
    public ChatUI(String username) {

        this.username = username;
    }
    public void start(Stage stage) {
        TextArea chatArea =
                new TextArea();

        chatArea.setEditable(false);

        TextField messageField =
                new TextField();

        Button sendButton =
                new Button("Send");

        ListView<String> onlineUsers =
                new ListView<>();
        HBox bottom =
                new HBox(
                        10,
                        messageField,
                        sendButton
                );
        BorderPane root =
                new BorderPane();

        root.setPadding(new Insets(10));

        root.setCenter(chatArea);

        root.setBottom(bottom);

        root.setRight(onlineUsers);
        Scene scene =
                new Scene(root, 600, 400);

        stage.setScene(scene);

        stage.setTitle(username);

        stage.show();

        sendButton.setOnAction(event -> {

            String message =
                    messageField.getText();

            client.sendMessage(message);

            messageField.clear();
        });
        System.out.println("CONNECT METHOD CALLED");
        client.connect(username);

        Thread receiveThread =
                new Thread(() -> {

                    try {

                        System.out.println("Waiting for messages...");

                        String message;

                        while ((message = client.getReader().readLine()) != null) {

                            String finalMessage = message;

                            Platform.runLater(() -> {

                                chatArea.appendText(
                                        finalMessage + "\n"
                                );
                            });
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                });

        receiveThread.start();

    }

}
