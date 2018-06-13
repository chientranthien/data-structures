package com.chientt.sstable.reader;

import com.chientt.sstable.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Base64;

/**
 *
 * @author chientt
 */
public class DataReader {

    public static final String DATA_PATH = "data.db";
    private static final String SEPARATED_CHAR = " ";

    public Data read(long offset) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(DATA_PATH, "rw");
        raf.seek(offset);
        String line = raf.readLine();
        String[] splited = line.split(SEPARATED_CHAR);
        byte[] decodedIndex = Base64.getDecoder().decode(splited[0]);
        byte[] decodedValue = Base64.getDecoder().decode(splited[1]);
        return new Data(new String(decodedIndex), new String(decodedValue));

    }
}
