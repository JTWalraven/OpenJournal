package com.jtechdev.openjournal.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.IndexRange;
import com.jtechdev.openjournal.Main;

/**
* The editor controller.
*
* @author Jeffrey Walraven
*/
public class EditorController {

    @FXML
    private TextArea editorTextArea;

    /**
     * The EditorController contructor.
     * Called before the initialize() method.
     */
    public EditorController() {}

    @FXML
    private void initialize() {
    }

    @FXML
    private void setBoldText() {
        String boldMark = "**";
        this.addTextDecoration(boldMark, boldMark, editorTextArea);
    }

    @FXML
    private void setItalicText() {
        String italicMark = "*";
        this.addTextDecoration(italicMark, italicMark, editorTextArea);
    }

    @FXML
    private void setUnderlineText() {
        String underlineBegin = "<ul>";
        String underlineEnd = "</ul>";
        this.addTextDecoration(underlineBegin, underlineEnd, editorTextArea);
    }

    @FXML
    private void setH1Text() {
        String h1Mark = "#";
        this.addTextDecoration(h1Mark, "", editorTextArea);
    }

    @FXML
    private void setH2Text() {
        String h2Mark = "##";
        this.addTextDecoration(h2Mark, "", editorTextArea);
    }

    @FXML
    private void setH3Text() {
        String h3Mark = "###";
        this.addTextDecoration(h3Mark, "", editorTextArea);
    }

    @FXML
    private void insertLink() {
        String linkBegin = "[";
        String linkEnd = "]()";
        this.addTextDecoration(linkBegin, linkEnd, editorTextArea);
    }

    @FXML
    private void insertImage() {
        String imageBegin = "![";
        String imageEnd = "]()";
        this.addTextDecoration(imageBegin, imageEnd, editorTextArea);
    }

    @FXML 
    private void insertBulletList() {
        String listBegin = "\n- ";
        String listEnd = "\n- ";
        this.addTextDecoration(listBegin, listEnd, editorTextArea);
    }

    @FXML 
    private void insertNumberedList() {
        String listBegin = "\n1. ";
        String listEnd = "\n2. ";
        this.addTextDecoration(listBegin, listEnd, editorTextArea);
    }

    @FXML
    private void insertBlockQuote() {
        String blockBegin = "\n> ";
        String blockEnd = "\n> ";
        this.addTextDecoration(blockBegin, blockEnd, editorTextArea);
    }

    /**
     * Adds a text decoration to the text in the editor.
     *
     * @param markBegin The beginning mark of the decoration
     * @param markEnd The end mark of the decoration
     * @param editorTextArea The text area to add the text decoration to
     */
    public void addTextDecoration(String markBegin, String markEnd, TextArea editorTextArea) {
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
