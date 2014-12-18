package com.jtechdev.openjournal.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import com.jtechdev.openjournal.Main;

/**
* The main application controller.
*
* @author Jeffrey Walraven
*/
public class ApplicationController {

    @FXML
    private TextArea editorTextArea;

    // Refrence to the main application
    private Main mainApp;

    /**
     * The contructor.
     * Called before the initialize() method.
     */
    public ApplicationController() {
    }

    @FXML
    private void initialize() {
    }

    /**
     * Set a refrence to the main Application.
     *
     * @param mainApp The {@link come.jtechdev.openjournal.Main}
     */
    public void setMain(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void setBoldText() {
        editorTextArea.appendText("****");
    }
}
