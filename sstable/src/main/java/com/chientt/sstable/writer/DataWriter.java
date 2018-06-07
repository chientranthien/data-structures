package com.chientt.sstable.writer;

import com.chientt.sstable.Data;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chientt
 */
public class DataWriter implements FileWriter {

    public static String DATA_FILE = "data.db";

    /**
     * key columnCount
     *
     * @param data
     * @return
     */
    @Override
    public void write(Data data) {
        try {
            List<String> lines = Arrays.asList(
                    data.index + data.word);
            Path file = Paths.get(DATA_FILE);
            Files.write(file, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
