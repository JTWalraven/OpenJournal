package com.jtechdev.openjournal.view;

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

    @FXML
    private TextArea editorTextArea;

    // Refrence to the main application
    private Main mainApp;

    // Seperate controllers that are called
    private EditorController editorController;

    /**
     * The contructor.
     * Called before the initialize() method.
     */
    public ApplicationController() {
        editorController = new EditorController();
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
        String boldMark = "**";
        editorController.addTextDecoration(boldMark, boldMark, editorTextArea);
    }

    @FXML
    private void setItalicText() {
        String italicMark = "*";
        editorController.addTextDecoration(italicMark, italicMark, editorTextArea);
    }

    @FXML
    private void setUnderlineText() {
        String underlineBegin = "<ul>";
        String underlineEnd = "</ul>";
        editorController.addTextDecoration(underlineBegin, underlineEnd, editorTextArea);
    }

    @FXML
    private void setH1Text() {
        String h1Mark = "#";
        editorController.addTextDecoration(h1Mark, "", editorTextArea);
    }

    @FXML
    private void setH2Text() {
        String h2Mark = "##";
        editorController.addTextDecoration(h2Mark, "", editorTextArea);
    }

    @FXML
    private void setH3Text() {
        String h3Mark = "###";
        editorController.addTextDecoration(h3Mark, "", editorTextArea);
    }

    @FXML
    private void insertLink() {
        String linkBegin = "[";
        String linkEnd = "]()";
        editorController.addTextDecoration(linkBegin, linkEnd, editorTextArea);
    }

    @FXML
    private void insertImage() {
        String imageBegin = "![";
        String imageEnd = "]()";
        editorController.addTextDecoration(imageBegin, imageEnd, editorTextArea);
    }
}
