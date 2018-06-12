package com.chientt.sstable.reader;

import com.chientt.sstable.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author chientt
 */
public class DataReader {

    public static final String INDEX_PATH = "index.db";
    private static final String SEPARATED_CHAR = " ";

    public Data read(long offset) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(INDEX_PATH, "rw");
        raf.seek(offset);
        String line = raf.readLine();
        String[] splited = line.split(SEPARATED_CHAR);
        return new Data(splited[0], splited[1]);

    }
}
