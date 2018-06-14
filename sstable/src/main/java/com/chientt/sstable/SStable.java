package com.chientt.sstable;

import com.chientt.sstable.reader.DataReader;
import com.chientt.sstable.reader.IndexReader;
import com.chientt.sstable.writer.DataWriter;
import com.chientt.sstable.writer.IndexWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chientt
 */
public class SStable {

    public Map<String, IndexData> indexes;
    private final DataReader dataReader = new DataReader();
    private final DataWriter dataWriter = new DataWriter();
    private final IndexWriter indexWriter = new IndexWriter();
    private final IndexReader reader = new IndexReader();

    public SStable() throws FileNotFoundException {
        indexes = reader.read();
    }

    public List<Data> find(String word) throws IOException {

        IndexData index = indexes.get(word);
        if (index == null) {
            return Collections.EMPTY_LIST;
        }
        List<Data> result = new ArrayList<>();
        for (Long offset : index.offsets) {
            Data data = dataReader.read(offset);
            result.add(data);
        }
        return result;
    }

    public void add(Data data) {
        long offset = dataWriter.write(data);
        IndexData indexData = indexes.get(data.index);
        if (indexData == null) {
            indexData = new IndexData(data.index, new HashSet<>());
        }
        indexData.offsets.add(offset);
        indexes.put(data.index, indexData);
        persistAllIndexs();
    }

    public void persistAllIndexs() {
        Collection<IndexData> indexData = indexes.values();
        indexWriter.write(indexData);
    }

}
