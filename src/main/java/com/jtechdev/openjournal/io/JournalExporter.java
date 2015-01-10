package com.jtechdev.openjournal.io;

import com.jtechdev.openjournal.model.Journal;
import com.jtechdev.openjournal.model.JournalEntry;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
* Exports the Journal to file.
*
* @author Jeffrey Walraven
*/
public class JournalExporter {

    /**
     * Export a Journal object to a YAML file.
     * Gets the file to export to from the Journal object.
     *
     * @param jrnl The Journal object to export
     */
    public void exportJournal(Journal jrnl) {
        this.exportJournal(jrnl, jrnl.getFile());
    }

    /**
     * Export a Journal object to a YAML file.
     *
     * @param jrnl The Journal object to export
     * @param file The File to exprt to
     */
    public void exportJournal(Journal jrnl, File file) throws IOException {
        ArrayList<Map> maps = new ArrayList<Map>();
        
        // Add the Journal
        Map jrnlMap = new HashMap();
        jrnlMap.put("Journal", jrnl.getTitle());
        jrnlMap.put("Creation Date", jrnl.getCreationDate());
        jrnlMap.put("Modification Date", jrnl.getModificationDate());
        maps.add(jrnlMap);

        // Add the Journal entries
        for (JournalEntry entry : jrnl) {
            Map entryMap = new HashMap();
            entryMap.put("Date", entry.getDate());
            entryMap.put("Body", entry.getBody());
            entryMap.put("Tags", entry.getTags());
            maps.add(entryMap);
        }

        // Export to StringWriter
        Yaml yaml = new Yaml();
        StringWriter sw = new StringWriter();
        yaml.dumpAll(maps.iterator(), sw);

        // Export File
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        fw.write(sw.toString());
        fw.close();
    }
}
