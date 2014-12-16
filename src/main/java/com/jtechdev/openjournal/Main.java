package com.jtechdev.openjournal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("open-journal-main.fxml"));

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(getClass().getResource("open-journal-main.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("write-panel.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("toolbar.css").toExternalForm());

        stage.setTitle("OpenJournal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
