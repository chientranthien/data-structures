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
public class IndexWriter implements FileWriter {

    public static String INDEX_PATH = "index.db";
    private static final char SEPARATED_CHAR = ' ';

    @Override
    public long write(Data data) {
        long pos = -1;
        try {
            List<String> lines = Arrays.asList(
                    data.word + SEPARATED_CHAR + data.index);
            Path path = Paths.get(INDEX_PATH);
            pos = Files.size(path);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pos;

    }

}
