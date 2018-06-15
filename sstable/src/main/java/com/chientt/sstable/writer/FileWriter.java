package com.chientt.sstable.writer;

import com.chientt.sstable.entity.Data;

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
