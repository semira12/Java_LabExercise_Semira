package com.mynotepad.mynotepad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets; // Fixes StandardCharsets error

import java.io.*;

public class TheNotepad extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root=new BorderPane();
        TextArea textArea=new TextArea();
        root.setCenter(textArea);
        MenuBar menuBar=new MenuBar();
        Menu filemenu=new Menu("FILE");
        MenuItem newItem=new MenuItem("New");
        MenuItem openItem=new MenuItem("open");
        MenuItem saveItem=new MenuItem("save");
        MenuItem exitItem=new MenuItem("Exit");
        filemenu.getItems().addAll(newItem,openItem,saveItem,exitItem);
        menuBar.getMenus().add(filemenu);
        Menu editMenu = new Menu("_Edit");

        MenuItem cutItem   = new MenuItem("Cut");
        MenuItem copyItem  = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem selectAll = new MenuItem("Select All");
        MenuItem clearItem = new MenuItem("Clear All");
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem, selectAll, clearItem);
        menuBar.getMenus().addAll(editMenu);


        root.setTop(menuBar);
        Scene scene =new Scene(root,500,500);
        primaryStage.setTitle(" my notepad ");
        primaryStage.setScene(scene);
        primaryStage.show();


        cutItem.setOnAction(e -> textArea.cut());
        copyItem.setOnAction(e -> textArea.copy());
        pasteItem.setOnAction(e -> textArea.paste());
        selectAll.setOnAction(e -> textArea.selectAll());
        clearItem.setOnAction(e -> textArea.clear());

        newItem.setOnAction(e ->{
            textArea.clear();
        });
        openItem.setOnAction(e->{
            FileChooser choose=new FileChooser();
            choose.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text file","*.txt")
            );

            File choosen= choose.showOpenDialog(primaryStage);
            if(choosen!=null) {
                   StringBuilder content=new StringBuilder();

                try (BufferedReader reader=new BufferedReader(new FileReader(choosen))){
                    String line;
                    while((line=reader.readLine())!=null){
                        content.append(line).append("\n");

                    }
                    textArea.setText(content.toString());
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                    textArea.setText("error loading");
                }
            }
        });
        saveItem.setOnAction(e->{
            FileChooser choose=new FileChooser();
            choose.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text","*.txt"));
            File choosen= choose.showSaveDialog(primaryStage);
            if(choosen!=null){
                StringBuilder content=new StringBuilder();
                try( BufferedWriter writer=new BufferedWriter(new FileWriter(choosen))){
                        writer.write(textArea.getText());

                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                    System.out.println("failed to save");
                }
            }

        });
        exitItem.setOnAction(e->{
            primaryStage.close();
            //Platform.exit();
        });
    }
}
