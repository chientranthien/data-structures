package com.chientt.sstable.writer;

import com.chientt.sstable.Data;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class DataWriterTests {

    @Test
    public void shouldWriteFile() {
        FileWriter dataWriter = new DataWriter();
        dataWriter.write(new Data("123", "data"));
    }
}
