package com.chientt.sstable.reader;

import com.chientt.sstable.IndexData;
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
        File file = new File("");
        try (Scanner scanner
                = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(" ");
                IndexData indexData = new IndexData();
                indexData.index = splited[0];
                indexData.offsets = extractOffets(splited);
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
