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

    /**
     * The EditorController contructor.
     */
    public EditorController() {}

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
