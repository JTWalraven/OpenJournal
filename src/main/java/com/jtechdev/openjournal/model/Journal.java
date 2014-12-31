package com.jtechdev.openjournal.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

/**
* The journal model that contains all journal data.
*
* @author Jeffrey Walraven
*/
public class Journal extends ArrayList<JournalEntry> {
    
    private String title;
    private File file;
    private Calendar creationDate;
    private Calendar modDate;

    /**
     * The Journal Constructor.
     */
    public Journal() {}

    /**
     * The Journal Constructor.
     *
     * @param title The title of the journal
     * @param file The link to the File the journal represents
     * @param creationDate The date the journal was created
     * @param modDate The last date the journal was modified
     */
    public Journal(String title, File file, Calendar creationDate, Calendar modDate) {
        this.title = title;
        this.file = file;
        this.creationDate = creationDate;
        this.modDate = modDate;
    }

    /**
     * Set the title of the journal.
     *
     * @param title The title of the journal
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the title of the journal.
     *
     * @return The title of the journal
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the File used by the journal.
     *
     * @param file The link to the File the journal represents
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Get the File used by the journal.
     *
     * @return The link to the File the journal represents
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Set the creation date of the journal.
     *
     * @param creationDate The date the journal was created
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Get the creation date of the journal.
     *
     * @return The date the journal was created
     */
    public Calendar getCreationDate() {
        return this.creationDate;
    }

    /**
     * Set the modification date of the journal.
     *
     * @param modDate The date the journal was modified
     */
    public void setModificationDate(Calendar modDate) {
        this.modDate = modDate;
    }

    /**
     * Set the modification date of the journal.
     *
     * @return The date the journal was modified
     */
    public Calendar getModificationDate() {
        return this.modDate;
    }

    /**
     * Set the modification date of the journal to the current date/time.
     */
    public void updateModificationDate() {
        this.modDate = Calendar.getInstance();
    }

}
