package com.chientt.sstable.reader;

import static com.chientt.sstable.constant.GlobalConstant.SEPARATED_CHAR;
import com.chientt.sstable.entity.IndexData;
import static com.chientt.sstable.writer.IndexWriter.INDEX_PATH;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class IndexReader {


    public Map<String, IndexData> read() throws FileNotFoundException {
        Map<String, IndexData> result = new HashMap<>();

        File file = new File(INDEX_PATH);
        if (!file.exists()) {
            return result;
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(SEPARATED_CHAR);
                IndexData indexData = new IndexData();
                indexData.index = splited[0];
                indexData.offsets = extractOffets(splited);
                result.put(indexData.index, indexData);
            }
        }

        return result;
    }

    private Set<Long> extractOffets(String[] splited) {
        Set<Long> offsets = new HashSet<>();
        for (int i = 1; i < splited.length; i++) {
            long offset = Long.valueOf(splited[i]);
            offsets.add(offset);
        }

        return offsets;
    }
}
