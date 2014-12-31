package com.jtechdev.openjournal.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
* A model containing a journal entry.
*
* @author Jeffrey Walraven
*/
public class JournalEntry {

    private Calendar date;
    private String body;
    private ArrayList<Tag> tags;

    /**
     * The JournalEntry constructor.
     */
    public JournalEntry() {}

    /**
     * The JournalEntry constructor.
     *
     * @param date The JournalEntry date
     * @param body The JournalEntry body
     * @param tags The JournalEntry tags
     */
    public JournalEntry(Calendar date, String body, ArrayList<Tag> tags) {
        this.date = date;
        this.body = body;
        this.tags = tags;
    }

    /**
     * Set the date of the journal entry.
     *
     * @param date The new date of the journal entry
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Get the date of the journal entry.
     *
     * @return The date of the journal entry
     */
    public Calendar getDate() {
        return this.date;
    }

    /**
     * Set the body text of the journal entry.
     *
     * @param body The new body of the journal entry
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Get the body text of the journal entry.
     *
     * @return The body of the journal entry
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Set the tags <pre>ArrayList</pre> in the journal entry.
     *
     * @param tags The new tags in the journal entry
     */
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Get the tags <pre>ArrayList</pre> in the journal entry.
     *
     * @return The tags in the journal entry
     */
    public ArrayList<Tag> getTags() {
        return this.tags;
    }
}
