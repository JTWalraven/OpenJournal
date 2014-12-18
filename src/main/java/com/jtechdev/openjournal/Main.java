package com.jtechdev.openjournal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * The central Application instance.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Import the fxml UI
        Parent root = FXMLLoader.load(getClass().getResource("view/open-journal-main.fxml"));

        // Initialize the scene
        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(getClass().getResource("open-journal-main.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("write-panel.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("toolbar.css").toExternalForm());

        // Initialize the stage variables
        stage.setTitle("OpenJournal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        Application.launch(args);
    }

}
