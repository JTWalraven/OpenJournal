package com.jtechdev.openjournal.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import com.jtechdev.openjournal.model.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.io.*;

/**
* Tests for {@link JournalExporter} and {@link JournalImporter}.
*
* @author Jeffrey Walraven
*/
@RunWith(JUnit4.class)
public class JournalIOTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void testIOJournal() {
        try {
            File tempFile = testFolder.newFile("testIO.yaml");  // Create the test file

            // Initialize test values
            Calendar date = Calendar.getInstance(); 
            Journal jrnl = new Journal("Work", null, date, date);
            for (int i = 0; i < 5; i++) {
                String mdString = "#Hello \n This is what I like to call: \n ##Markdown";
                mdString += "\n *Signed: Journal Entry " + i + "*";
                ArrayList<Tag> tags = new ArrayList<Tag>();
                Tag tag = new Tag("Test");
                tags.add(tag);
                JournalEntry jrnlEntry = new JournalEntry(date, mdString, tags);
                jrnl.add(jrnlEntry);
            }

            // Initialize Journal Exporter
            JournalExporter jrnlExport = new JournalExporter();

            // Export to file
            jrnlExport.exportJournal(jrnl, tempFile);

            // Initialize Journal Importer
            JournalImporter jrnlImport = new JournalImporter();
            Journal nwJrnl = new Journal();

            // Import file
            try {
                nwJrnl = jrnlImport.importJournal(tempFile);
            } catch (FileNotFoundException e) {
                System.err.println(e.toString());
            }

            // Compare Journals
            assertEquals("Journal titles should match", jrnl.getTitle(), nwJrnl.getTitle());
            assertEquals("Creation dates should match", jrnl.getCreationDate(), nwJrnl.getCreationDate());
            assertEquals("Modification dates should match", jrnl.getModificationDate(), nwJrnl.getModificationDate());

            // Compare Journal entries
            for (JournalEntry entry : jrnl) {
                boolean dateMatches = false;
                boolean bodyMatches = false;
                for (JournalEntry nwEntry : nwJrnl) {
                    if (entry.getDate().equals(nwEntry.getDate())) {
                        dateMatches = true;
                    }
                    if (entry.getBody().equals(nwEntry.getBody())) {
                        bodyMatches = true;
                    }

                    // Compare Journal entry tags
                    boolean tagMatches = false;
                    for (Tag tag : entry.getTags()) {
                        for (Tag nwTag : nwEntry.getTags()) {
                            if (tag.getTagName().equals(nwTag.getTagName())) {
                                tagMatches = true;
                            }
                        }
                        assertTrue("A tag does not have a match", tagMatches);
                    }
                }
                assertTrue("The date of a journal entry has no match", dateMatches);
                assertTrue("The body of a journal entry has no match", bodyMatches);
            }
        } catch(IOException e) {
            System.err.println(e.toString());
        }
    }
}
