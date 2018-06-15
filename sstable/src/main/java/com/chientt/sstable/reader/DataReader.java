package com.chientt.sstable.reader;

import static com.chientt.sstable.constant.GlobalConstant.DATA_PATH;
import com.chientt.sstable.entity.Data;
import com.chientt.sstable.util.DataUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author chientt
 */
public class DataReader {

    public Data read(long offset) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(DATA_PATH, "rw");
        raf.seek(offset);
        String line = raf.readLine();

        return DataUtils.decodeDataStr(line);

    }

}
