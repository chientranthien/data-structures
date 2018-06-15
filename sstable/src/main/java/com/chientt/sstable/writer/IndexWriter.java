package com.chientt.sstable.writer;

import com.chientt.sstable.entity.IndexData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
            String line = makeLine(data);
            List<String> lines = Arrays.asList(line);
            Path path = Paths.get(INDEX_PATH);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            pos = Files.size(path);

            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pos;

    }

    private String makeLine(IndexData data) {
        String line = data.index;
        for (long offset : data.offsets) {
            line += SEPARATED_CHAR + offset;
        }
        return line;
    }

    public void write(Collection<IndexData> indexData) {
        try {

            List<String> lines = new ArrayList<>();
            for (IndexData aIndexData : indexData) {
                String line = makeLine(aIndexData);
                lines.add(line);
            }
            lines.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            Path path = Paths.get(INDEX_PATH);
            Files.write(path, lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
