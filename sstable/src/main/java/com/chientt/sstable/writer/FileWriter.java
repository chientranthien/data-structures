package com.chientt.sstable.writer;

import com.chientt.sstable.Data;

/**
 *
 * @author chientt
 */
public interface FileWriter {

    /**
     *
     */
    long write(Data data);
}
