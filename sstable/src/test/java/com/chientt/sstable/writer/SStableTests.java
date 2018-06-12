package com.chientt.sstable.writer;

import com.chientt.sstable.Data;
import com.chientt.sstable.SStable;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class SStableTests {

    @Test
    public void test() throws FileNotFoundException {
        SStable sstable = new SStable();
        sstable.add(new Data("word", "this doc contains a word"));
        sstable.persistAllIndexs();
    }
}
