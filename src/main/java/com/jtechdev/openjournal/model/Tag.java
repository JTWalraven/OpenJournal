package com.jtechdev.openjournal.model;

/**
* A model containing a journal entry tag's data.
*
* @author Jeffrey Walraven
*/
public class Tag {
    
    private String tagName;

    /**
     * The Tag constructor.
     */
    public Tag() {
    }

    /**
     * The Tag constructor.
     *
     * @param nm The name of the Tag
     */
    public Tag(String nm) {
        this.tagName = nm;
    }

    /**
     * Get the name of the tag.
     *
     * @return The name of the tag
     */
    public String getTagName() {
        return this.tagName;
    }

    /**
     * Set the name of the tag.
     *
     * @param nm The name of the tag
     */
    public void setTagName(String nm) {
        this.tagName = nm;
    }
}
