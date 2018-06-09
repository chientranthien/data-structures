package com.chientt.sstable.writer;

import com.chientt.sstable.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * @author chientt
 */
public class DataWriter implements FileWriter {

    public static String DATA_PATH = "data.db";

    /**
     * key columnCount
     *
     * @param data
     * @return
     */
    @Override
    public long write(Data data) {
        long pos = -1;
        try {
            List<String> lines = Arrays.asList(
                    data.index + data.word);
            Path path = Paths.get(DATA_PATH);
            pos = Files.size(path);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pos;

    }

}
