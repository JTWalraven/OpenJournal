package com.jtechdev.openjournal.io;

import com.jtechdev.openjournal.model.Tag;
import com.jtechdev.openjournal.model.Journal;
import com.jtechdev.openjournal.model.JournalEntry;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
* Imports a file to a Journal object.
*
* @author Jeffrey Walraven
*/
public class JournalImporter {

    /**
     * Imports a YAML file into a Journal object.
     *
     * @param file The File to import
     * @return The imported Journal object
     * @throws FileNotFoundException
     */
    public Journal importJournal(File file) throws FileNotFoundException {
        InputStream input = new FileInputStream(file);

        // Create the new Journal import object
        Journal jrnl = new Journal();
        jrnl.setFile(file);

        // Initialize the YAML importer
        Yaml yaml = new Yaml();
        for (Object obj : yaml.loadAll(input)) {
            Map map = (Map) obj;
            if (map.containsKey("Journal")) { // Check if it is a journal
                jrnl.setTitle((String) map.get("Journal"));
                Calendar creationDate = Calendar.getInstance();
                creationDate.setTime((Date) map.get("Creation Date"));
                jrnl.setCreationDate(creationDate);
                Calendar modDate = Calendar.getInstance();
                modDate.setTime((Date) map.get("Modification Date"));
                jrnl.setModificationDate(modDate);
            } else { // or a journal entry
                JournalEntry jrnlEntry = new JournalEntry();
                Calendar date = Calendar.getInstance();
                date.setTime((Date) map.get("Date"));
                jrnlEntry.setDate(date);
                jrnlEntry.setBody((String) map.get("Body"));
                jrnlEntry.setTags((ArrayList<Tag>) map.get("Tags"));
                jrnl.add(jrnlEntry);
            }
        }

        // Return the journal file
        return jrnl;
    }
}
