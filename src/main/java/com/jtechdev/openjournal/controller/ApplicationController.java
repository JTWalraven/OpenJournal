package com.jtechdev.openjournal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.IndexRange;
import com.jtechdev.openjournal.Main;

/**
* The main application controller.
*
* @author Jeffrey Walraven
*/
public class ApplicationController {

    // Refrence to the main application
    private Main mainApp;

    // Seperate controllers that are called
    private EditorController editorController;

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

}
