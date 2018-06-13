package com.chientt.sstable.writer;

import com.chientt.sstable.IndexData;

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
public class IndexWriter {

    public static String INDEX_PATH = "index.db";
    private static final String SEPARATED_CHAR = " ";

    public long write(IndexData data) {
        long pos = -1;
        try {
            String line = data.index;
            for (long offset : data.offsets) {
                line += SEPARATED_CHAR + offset;
            }
            List<String> lines = Arrays.asList(line);
            Path path = Paths.get(INDEX_PATH);

            if (Files.exists(path)) {
                pos = Files.size(path);

            }
            Files.write(path, lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pos;

    }

}
