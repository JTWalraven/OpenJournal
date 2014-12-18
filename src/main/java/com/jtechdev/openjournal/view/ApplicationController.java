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
        String boldMark = "**";
        this.addTextDecoration(boldMark, boldMark);
    }

    @FXML
    private void setItalicText() {
        String italicMark = "*";
        this.addTextDecoration(italicMark, italicMark);
    }

    @FXML
    private void setUnderlineText() {
        String underlineBegin = "<ul>";
        String underlineEnd = "</ul>";
        this.addTextDecoration(underlineBegin, underlineEnd);
    }

    @FXML
    private void setH1Text() {
        String h1Mark = "#";
        this.addTextDecoration(h1Mark, "");
    }

    @FXML
    private void setH2Text() {
        String h2Mark = "##";
        this.addTextDecoration(h2Mark, "");
    }

    @FXML
    private void setH3Text() {
        String h3Mark = "###";
        this.addTextDecoration(h3Mark, "");
    }

    private void addTextDecoration(String markBegin, String markEnd) {
        IndexRange selection = editorTextArea.getSelection();
        if (selection.getLength() > 0) {
            // Add bold marks to the beginning and end of the selection
            editorTextArea.insertText(selection.getEnd(), markEnd);
            editorTextArea.insertText(selection.getStart(), markBegin);
        } else {
            // Append the bold marks at the caret position and set the cursor in between
            int caretPos = editorTextArea.getCaretPosition();
            int endPos = caretPos + markBegin.length();
            editorTextArea.insertText(caretPos, markBegin);
            editorTextArea.insertText(endPos, markEnd);
            editorTextArea.positionCaret(endPos);
        }

        // Set focus on the text area so editing can continue as normal
        editorTextArea.requestFocus();
    }
}
